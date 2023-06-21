package com.module.pyyh.communication.init.serviceimp;

import java.net.InetSocketAddress;

import com.module.pyyh.communication.init.lizer.HttpServerInitializer;
import com.module.pyyh.communication.init.service.ACommunicationOperate;
import com.module.pyyh.communication.pojo.CommunicationConfigPojo;
import com.module.pyyh.communication.pojo.LizerConfigPojo;
import com.module.pyyh.communication.util.BaseUtil;
import com.module.pyyh.communication.util.ContainerUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class HttpServerImp<R, P> extends ACommunicationOperate<R, P>{
	private EventLoopGroup boss;
	private EventLoopGroup work;
	private ServerBootstrap boot;
	public HttpServerImp(P p) {
		super(p);
		// TODO Auto-generated constructor stub
		this.boss = new NioEventLoopGroup();
		this.work = new NioEventLoopGroup();
		this.boot = new ServerBootstrap();
	}

	@Override
	public R initSource(P p) throws Exception {
		// TODO Auto-generated method stub.
		CommunicationConfigPojo ccp = (CommunicationConfigPojo)p;
		LizerConfigPojo lcp = BaseUtil.dataToJson(1, 
				BaseUtil.loadFile(BaseUtil.listFile(ContainerUtil.getAPPLICATION_ROOT_PATH() + "/source-config/", "lizer-" + ccp.getType())[0].getAbsolutePath()), 
				LizerConfigPojo.class);
		for(String s : lcp.getHandlers()){
			String[] _s = s.split("_");
			ContainerUtil.getHandlers().put(_s[0], _s[1]);
		}
		HttpServerInitializer lizer = BaseUtil.instanceLoader(HttpServerInitializer.class, null, null, lcp.getImpClass());
		lizer.setLcp(lcp);
		boot.group(boss, work).channel(NioServerSocketChannel.class)
		.option(ChannelOption.SO_BACKLOG, ccp.getQueueSize())
		.childOption(ChannelOption.RCVBUF_ALLOCATOR, 
				new AdaptiveRecvByteBufAllocator(ccp.getMiniBuf(), ccp.getInitBuf(), ccp.getMaxBuf()))
		.childHandler(lizer);
		for(String adr : ccp.getAddresses()){
			String[] adrs = adr.split(":");
			ChannelFuture future = boot.bind(new InetSocketAddress(adrs[0], Integer.parseInt(adrs[1])));
			ContainerUtil.getHttpServerChannelFuture().put(adr, future);
		}
		
		return null;
	}

	@Override
	public R registSource(P p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
