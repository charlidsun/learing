package com.sun.nettyLearning.imooc;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月11日 下午4:50:45
 */
public class SimpleChatServer {

	private int port;
	
	public SimpleChatServer(int port){
		this.port = port;
	}
	
	public void run() throws Exception{
		NioEventLoopGroup boosGroup = new NioEventLoopGroup();
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		try{
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(boosGroup, workGroup)
							.channel(NioServerSocketChannel.class)
							.option(ChannelOption.SO_BACKLOG, 128)
							.childOption(ChannelOption.SO_KEEPALIVE, true)
							.childHandler(new SimpleChatServerInitializer());
			ChannelFuture f = serverBootstrap.bind(port).sync();
			f.channel().closeFuture().sync();
		}finally{
			boosGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}

	}
	
	
	public static void main(String[] args) throws Exception {
		new SimpleChatServer(7000).run();
	}
}
