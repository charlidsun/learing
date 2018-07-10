package com.sun.nettyLearning.utils;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月10日 下午3:14:25
 */
public class NettyClient {

	public static void main(String[] args) throws InterruptedException {
		NioEventLoopGroup group = new NioEventLoopGroup();
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.group(group)
				.channel(NioSocketChannel.class)
				.handler(new ChannelInitializer<Channel>() {
					@Override
					protected void initChannel(Channel ch) throws Exception {
						ch.pipeline().addLast(new StringEncoder());
					}
				});
		Channel channel =  bootstrap.connect("127.0.0.1", 8999).channel();
		while (true) {
			channel.writeAndFlush("sunjingge hello");
			Thread.sleep(20000);
		}
	}
}
