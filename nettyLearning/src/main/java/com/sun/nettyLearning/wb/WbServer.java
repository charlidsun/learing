package com.sun.nettyLearning.wb;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月12日 下午1:38:51
 */
public class WbServer {	
	
	public void run() throws Exception{
		NioEventLoopGroup boosGroup = new NioEventLoopGroup();
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		InetSocketAddress  address = new InetSocketAddress("127.0.0.1", 9091);
		try{
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(boosGroup,workGroup)
							.channel(NioServerSocketChannel.class)
							.handler(new LoggingHandler(LogLevel.INFO))
							.childHandler(new WbChannelInitializer());
			ChannelFuture future = serverBootstrap.bind(address).sync();
			future.channel().closeFuture().sync();
		}finally{
			boosGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new WbServer().run();
	}
}
