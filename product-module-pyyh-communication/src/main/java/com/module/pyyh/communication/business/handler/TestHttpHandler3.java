package com.module.pyyh.communication.business.handler;

import com.module.pyyh.communication.util.OperateUtil;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderValues;

public class TestHttpHandler3 extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		if(msg instanceof FullHttpRequest){
			System.out.println("3   " + msg.getClass() + "   " + ctx.channel().remoteAddress() + "   " + ctx.channel().localAddress());
			ctx.writeAndFlush(OperateUtil.httpResponse(HttpHeaderValues.APPLICATION_JSON, "阿西吧3"))
			.addListener(ChannelFutureListener.CLOSE);
			ctx.fireChannelRead(msg);
		}
	}

}
