package com.module.pyyh.communication.util;

import java.util.HashMap;

import io.netty.channel.ChannelFuture;

public class ContainerUtil {
	//根路径
	private static String APPLICATION_ROOT_PATH;
	//tcpServer缓存
	private static HashMap<String, ChannelFuture> tcpServerChannelFuture = new HashMap<>();
	private static HashMap<String, ChannelFuture> udpChannelFuture = new HashMap<>();
	//tcpHandler缓存
	private static HashMap<String, String> handlers = new HashMap<>();
	
	public static HashMap<String, String> getHandlers() {
		return handlers;
	}

	public static void setHandlers(HashMap<String, String> handlers) {
		ContainerUtil.handlers = handlers;
	}

	public static HashMap<String, ChannelFuture> getTcpServerChannelFuture() {
		return tcpServerChannelFuture;
	}

	public static HashMap<String, ChannelFuture> getUdpChannelFuture() {
		return udpChannelFuture;
	}

	public static void setUdpChannelFuture(HashMap<String, ChannelFuture> udpChannelFuture) {
		ContainerUtil.udpChannelFuture = udpChannelFuture;
	}

	public static void setTcpServerChannelFuture(HashMap<String, ChannelFuture> tcpServerChannelFuture) {
		ContainerUtil.tcpServerChannelFuture = tcpServerChannelFuture;
	}

	public static String getAPPLICATION_ROOT_PATH() {
		return APPLICATION_ROOT_PATH;
	}

	public static void setAPPLICATION_ROOT_PATH(String aPPLICATION_ROOT_PATH) {
		APPLICATION_ROOT_PATH = aPPLICATION_ROOT_PATH;
	}
	
}
