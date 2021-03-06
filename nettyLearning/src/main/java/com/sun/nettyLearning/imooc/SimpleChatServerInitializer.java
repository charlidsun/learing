package com.sun.nettyLearning.imooc;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月11日 下午5:05:09
 */
public class SimpleChatServerInitializer extends ChannelInitializer<SocketChannel>{

	
	@Override
	protected void initChannel(SocketChannel arg0) throws Exception {
		ChannelPipeline pipeline = arg0.pipeline();
		pipeline.addLast("handler",new SimpleChatServerHandler());
		pipeline.addLast("decoder",new StringDecoder());
		pipeline.addLast("encoder", new StringEncoder());
		pipeline.addLast("framer",new DelimiterBasedFrameDecoder(8192,Delimiters.lineDelimiter()));
	
		System.out.println("SimpleChatClient:"+arg0.remoteAddress() +"连接上");
	}

}
