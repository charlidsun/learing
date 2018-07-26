package com.sun.fileSys.list;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月23日 下午5:02:56
 */
public class FileSysServer {
	
	final String host = "127.0.0.1";
	final int port = 8070;
	static final String url = "/src/main/java/netty";
	
	//将地址和端口号传递进来
	public void run(){
		NioEventLoopGroup boosGroup = new NioEventLoopGroup();
		NioEventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(boosGroup, workGroup)
				.channel(NioServerSocketChannel.class)
				.childHandler(new FileSysChildHandler());
			ChannelFuture c = serverBootstrap.bind(host, port).sync();
			c.channel().closeFuture().sync();
		} catch (Exception e) {
			boosGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) {
		new FileSysServer().run();
	}

}
