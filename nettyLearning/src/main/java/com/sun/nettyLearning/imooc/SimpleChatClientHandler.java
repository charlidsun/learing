package com.sun.nettyLearning.imooc;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月11日 下午6:28:27
 */
public class SimpleChatClientHandler extends SimpleChannelInboundHandler<String>{

	
	@Override
	protected void channelRead0(ChannelHandlerContext arg0, String arg1)
			throws Exception {
		System.out.println(arg1);
	}

}
