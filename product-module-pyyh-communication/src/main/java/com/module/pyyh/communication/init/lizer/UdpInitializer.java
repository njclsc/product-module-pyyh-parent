package com.module.pyyh.communication.init.lizer;

import com.module.pyyh.communication.pojo.LizerConfigPojo;
import com.module.pyyh.communication.util.BaseUtil;
import com.module.pyyh.communication.util.ContainerUtil;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.DatagramChannel;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UdpInitializer extends ChannelInitializer<DatagramChannel>{
	private LizerConfigPojo lcp;
	@Override
	protected void initChannel(DatagramChannel arg0) throws Exception {
		// TODO Auto-generated method stub
		for(String s : lcp.getBusinessOrder()){
			arg0.pipeline().addLast(BaseUtil.instanceLoader(ChannelHandler.class, null, null, ContainerUtil.getHandlers().get(s)));
		}
	}

}
