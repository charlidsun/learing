package com.sun.nettyLearning.utils;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月10日 下午2:55:55
 */
public class NettyServcer {

	public static void main(String[] args) {
		
		NioEventLoopGroup boosGroup = new NioEventLoopGroup();
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		serverBootstrap.group(boosGroup, workGroup)
						.channel(NioServerSocketChannel.class)
						.childHandler(new ChannelInitializer<NioSocketChannel>() {

							@Override
							protected void initChannel(NioSocketChannel ch)
									throws Exception {
								ch.pipeline().addLast(new StringDecoder());
								ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {

									@Override
									protected void channelRead0(
											ChannelHandlerContext ctx,
											String msg) throws Exception {
										System.out.println(msg);
									}
								});
							}
						
						});
		serverBootstrap.bind(8999);
	}
	
	
}
