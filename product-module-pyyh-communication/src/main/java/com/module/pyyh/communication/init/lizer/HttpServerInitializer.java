package com.module.pyyh.communication.init.lizer;

import com.module.pyyh.communication.pojo.LizerConfigPojo;
import com.module.pyyh.communication.util.BaseUtil;
import com.module.pyyh.communication.util.ContainerUtil;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HttpServerInitializer extends ChannelInitializer<SocketChannel>{
	private LizerConfigPojo lcp;
	@Override
	protected void initChannel(SocketChannel arg0) throws Exception {
		// TODO Auto-generated method stub
		arg0.pipeline().addLast(new HttpResponseEncoder());
		arg0.pipeline().addLast(new HttpRequestDecoder());
		arg0.pipeline().addLast(new HttpObjectAggregator(512 * 1024));
		for(String s : lcp.getBusinessOrder()){
			arg0.pipeline().addLast(BaseUtil.instanceLoader(ChannelHandler.class, null, null, ContainerUtil.getHandlers().get(s)));
		}
		
	}

}
