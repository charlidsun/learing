 package com.sun.nettyLearning.imooc;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月11日 下午6:12:41
 */
public class SimpleChatClient {
	
	private int port;
	private String localhost;
	
	public SimpleChatClient(int port,String localhost){
		this.port = port;
		this.localhost = localhost;
	}
	
	public void run(){
		NioEventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(group)
					.channel(NioSocketChannel.class)
					.handler(new SimpleChatClientInitializer());
			Channel channel = bootstrap.connect(localhost, port).sync().channel();
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
			while(true){ 
				channel.writeAndFlush(in.readLine() + "\r\n"); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			group.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) {
		new SimpleChatClient(7000, "127.0.0.1").run();;
	}
}
