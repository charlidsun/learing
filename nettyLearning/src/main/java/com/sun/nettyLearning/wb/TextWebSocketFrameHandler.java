package com.sun.nettyLearning.wb;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.HashMap;
import java.util.Map;

import com.sun.nettyLearning.entity.TransMsg;
import com.sun.nettyLearning.trans.JsonUtils;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月12日 下午1:58:19
 */
public class TextWebSocketFrameHandler extends
		SimpleChannelInboundHandler<TextWebSocketFrame> {

	private static ChannelGroup channelGroup = new DefaultChannelGroup(
			GlobalEventExecutor.INSTANCE);
	private Map<String,Object> onLine = new HashMap<String, Object>();

	// 每个channel都有一个唯一的id值
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		// 上线 asLongText方法是channel的id的全名
		System.out.println("handlerAdded：" + ctx.channel().id().asLongText());
		// 增加到ChannelGroup
		channelGroup.add(ctx.channel());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		// 下线
		System.out.println("handlerRemoved：" + ctx.channel().id().asLongText());
		// 移除到ChannelGroup
		channelGroup.remove(ctx.channel());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		System.out.println("异常发生");
		ctx.close();
	}

	// 读到客户端的内容并且向客户端去写内容
	@Override
	protected void channelRead0(ChannelHandlerContext ctx,
			TextWebSocketFrame msg) throws Exception {

		System.out.println("收到消息：" + msg.text());
		TransMsg t = transMsg(ctx.channel(),msg.text());
		System.out.println(t);
		if (t.getMgsType() != 1001){
			for(Channel channel:channelGroup){
				System.out.println("---------------");
				System.out.println(channel.id().asLongText());
				System.out.println(t.getUserId());
				System.out.println("\n");
			    if(channel.id().asLongText().equals(t.getUserId())) {
			    	   System.out.println("验证正确");
			           channel.writeAndFlush(new TextWebSocketFrame("发送消息-》"+t.getMsg()));
			    }
			}
		}else{
			/**
			 * writeAndFlush接收的参数类型是Object类型，但是一般我们都是要传入管道中传输数据的类型，比如我们当前的demo
			 * 传输的就是TextWebSocketFrame类型的数据
			 */
			ctx.channel().writeAndFlush(
					new TextWebSocketFrame("上线成功！@"+t.getUserId()));
		}
		
		
	}
	
	
	
	public TransMsg transMsg(Channel c,String msg){
		
		TransMsg transMsg = JsonUtils.jsonToBean(msg, TransMsg.class);
		
		if (transMsg.getMgsType() == 1001){
			transMsg.setUserId(c.id().asLongText());
			onLine.put(c.id().asLongText(), transMsg.getToUserId());
		}
		
		return transMsg;
	}
	
	

}
