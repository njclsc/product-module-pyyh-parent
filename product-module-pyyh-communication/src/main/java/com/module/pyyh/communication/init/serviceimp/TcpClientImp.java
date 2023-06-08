package com.module.pyyh.communication.init.serviceimp;

import java.net.InetSocketAddress;

import com.module.pyyh.communication.init.lizer.TcpClientInitalizer;
import com.module.pyyh.communication.init.service.ACommunicationOperate;
import com.module.pyyh.communication.pojo.CommunicationConfigPojo;
import com.module.pyyh.communication.pojo.LizerConfigPojo;
import com.module.pyyh.communication.util.BaseUtil;
import com.module.pyyh.communication.util.ContainerUtil;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TcpClientImp<R, P> extends ACommunicationOperate<R, P> {
	private EventLoopGroup work;
	private Bootstrap boot;
	public TcpClientImp(P p) {
		super(p);
		// TODO Auto-generated constructor stub
		this.work = new NioEventLoopGroup();
		this.boot = new Bootstrap();
	}

	@Override
	public R initSource(P p) throws Exception {
		// TODO Auto-generated method stub
		CommunicationConfigPojo ccp = (CommunicationConfigPojo)p;
		LizerConfigPojo lcp = BaseUtil.dataToJson(1, 
				BaseUtil.loadFile(BaseUtil.listFile(ContainerUtil.getAPPLICATION_ROOT_PATH() + "/source-config/", "lizer-" + ccp.getType())[0].getAbsolutePath()), 
				LizerConfigPojo.class);
		for(String s : lcp.getHandlers()){
			String[] _s = s.split("_");
			ContainerUtil.getHandlers().put(_s[0], _s[1]);
		}
		TcpClientInitalizer lizer = BaseUtil.instanceLoader(TcpClientInitalizer.class, null, null, lcp.getImpClass());
		lizer.setLcp(lcp);
		boot.group(work).channel(NioSocketChannel.class).option(ChannelOption.RCVBUF_ALLOCATOR, 
				new AdaptiveRecvByteBufAllocator(ccp.getMiniBuf(), ccp.getInitBuf(), ccp.getMaxBuf())).handler(lizer);
		for(String adr : ccp.getAddresses()){
			String[] addresses = adr.split("_to_");
			String[] localAddr = addresses[0].split(":");
			String[] remoteAddr = addresses[1].split(":");
			ChannelFuture future = boot.connect(new InetSocketAddress(remoteAddr[0], Integer.parseInt(remoteAddr[1])), new InetSocketAddress(localAddr[0], Integer.parseInt(localAddr[1])));
			ContainerUtil.getTcpClientChannelFuture().put(addresses[0], future);
		}
		return null;
	}

	@Override
	public R registSource(P p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
