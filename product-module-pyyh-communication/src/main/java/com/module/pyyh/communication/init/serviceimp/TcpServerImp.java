package com.module.pyyh.communication.init.serviceimp;

import com.module.pyyh.communication.init.service.ACommunicationOperate;
import com.module.pyyh.communication.pojo.CommunicationConfigPojo;
import com.module.pyyh.communication.util.ContainerUtil;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TcpServerImp<R, P> extends ACommunicationOperate<R, P>{
	private EventLoopGroup boss;
	private EventLoopGroup work;
	private ServerBootstrap boot;
	
	public TcpServerImp(P p) {
		super(p);
		// TODO Auto-generated constructor stub
		this.boss = new NioEventLoopGroup();
		this.work = new NioEventLoopGroup();
		this.boot = new ServerBootstrap();
	}

	@Override
	public R initSource(P p) {
		// TODO Auto-generated method stub
		CommunicationConfigPojo ccp = (CommunicationConfigPojo)p;
		boot.group(boss, work).channel(NioServerSocketChannel.class)
		.option(ChannelOption.SO_BACKLOG, ccp.getQueueSize())
		.childOption(ChannelOption.RCVBUF_ALLOCATOR, 
				new AdaptiveRecvByteBufAllocator(ccp.getMiniBuf(), 
						ccp.getInitBuf(), ccp.getMaxBuf()));
		return null;
	}

	@Override
	public R registSource(P p) {
		// TODO Auto-generated method stub
		CommunicationConfigPojo ccp = (CommunicationConfigPojo)p;
		System.out.println(ccp);
		return null;
	}

}
