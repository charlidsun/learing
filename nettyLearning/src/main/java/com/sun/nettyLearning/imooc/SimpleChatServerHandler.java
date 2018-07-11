package com.sun.nettyLearning.imooc;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月11日 下午5:14:09
 */
public class SimpleChatServerHandler extends
		SimpleChannelInboundHandler<String> {

	private static ChannelGroup channelGroup = new DefaultChannelGroup(
			GlobalEventExecutor.INSTANCE);

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel();
		for (Channel channel : channelGroup) {
			channel.writeAndFlush("[server]:" + incoming.remoteAddress()
					+ "加入\n");
		}
		channelGroup.add(ctx.channel());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel();
		for (Channel channel : channelGroup) {
			channel.writeAndFlush("[server]:" + incoming.remoteAddress()
					+ "离开\n");
		}
		channelGroup.add(ctx.channel());
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String s)
			throws Exception {
		Channel incoming = ctx.channel();
		for (Channel channel : channelGroup) {
			if (channel != incoming) {
				channel.writeAndFlush("[" + incoming.remoteAddress() + "]" + s
						+ "\n");
			} else {
				channel.writeAndFlush("[you]" + s + "\n");
			}
		}
	}
	
	@Override 
	public void channelActive(ChannelHandlerContext ctx) throws Exception { 
		Channel incoming = ctx.channel(); 
		System.out.println("SimpleChatClient:"+incoming.remoteAddress()+"在线"); 
	}
		
	@Override 
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		Channel incoming = ctx.channel(); 
		System.out.println("SimpleChatClient:"+incoming.remoteAddress()+"掉线"); 
	}
	
	@Override 
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { 
		Channel incoming = ctx.channel(); 
		System.out.println("SimpleChatClient:"+incoming.remoteAddress()+"异常"); 
		// 当出现异常就关闭连接 
		cause.printStackTrace(); 
		ctx.close(); 
	}
}
