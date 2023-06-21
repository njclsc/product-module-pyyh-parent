package com.module.pyyh.communication.util;

import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;

public class OperateUtil {

	//httpserver回复
	public static DefaultFullHttpResponse httpResponse(AsciiString contentType, Object data){
		 DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
	                HttpResponseStatus.OK,
	                Unpooled.wrappedBuffer(((String)data).getBytes()));
		 response.headers().add(HttpHeaderNames.CONTENT_TYPE, contentType + "; charset=UTF-8")
		 	.add(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes())
		 	.add(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
		return response;
	}
}
