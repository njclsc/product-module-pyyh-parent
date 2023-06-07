package com.module.pyyh.communication.init.lizer;

import java.util.HashMap;

import com.module.pyyh.communication.pojo.LizerConfigPojo;
import com.module.pyyh.communication.util.BaseUtil;
import com.module.pyyh.communication.util.ContainerUtil;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TcpServerInitializer extends ChannelInitializer<SocketChannel>{
	private LizerConfigPojo lcp;
	@Override
	protected void initChannel(SocketChannel arg0) throws Exception {
		// TODO Auto-generated method stub
		for(String s : lcp.getBusinessOrder()){
			arg0.pipeline().addLast(BaseUtil.instanceLoader(ChannelHandler.class, null, null, ContainerUtil.getHandlers().get(s)));
		}
	}
	
}
