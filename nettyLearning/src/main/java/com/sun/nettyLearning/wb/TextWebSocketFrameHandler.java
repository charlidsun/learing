package com.sun.nettyLearning.wb;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.sun.nettyLearning.chat.entity.ChatHistory;
import com.sun.nettyLearning.chat.service.ChatService;
import com.sun.nettyLearning.config.SpringUtil;
import com.sun.nettyLearning.entity.TransMsg;
import com.sun.nettyLearning.trans.JsonUtils;
import com.sun.nettyLearning.user.entity.UserInfo;
import com.sun.nettyLearning.user.service.UserInfoService;
import com.sun.nettyLearning.utils.TransUtils;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import net.sf.json.JSONObject;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月12日 下午1:58:19
 */
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

	UserInfoService userInfoService = SpringUtil.getBean(UserInfoService.class);
	ChatService chatService = SpringUtil.getBean(ChatService.class);

	private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	private static Map<String, Object> onLine = new HashMap<String, Object>();

	
	// 每个channel都有一个唯一的id值
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		// 上线 asLongText方法是channel的id的全名
		System.out.println("新的连接加入啦-》：" + ctx.channel().id().asLongText());
		// 增加到ChannelGroup
		channelGroup.add(ctx.channel());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		// 下线
		System.out.println("有朋友下线了：" + ctx.channel().id().asLongText());
		// 移除到ChannelGroup
		channelGroup.remove(ctx.channel());
		// 根据channel，移除map。
		String key = TransUtils.getKeyByValue(onLine, ctx.channel().id().asLongText());
		onLine.remove(key);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		System.out.println("异常发生");
		ctx.close();
	}

	// 读到客户端的内容并且向客户端去写内容
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

		Channel c = ctx.channel();
		Map<String, Object> resMap = new HashMap<>();

		TransMsg t = transMsg(msg.text());

		// 1001，连接协议，将用户信息保存起来
		if (t.getMgsType() == 1001) {
			// 首先保存到map里面
			onLine.put(t.getUserId(),c.id().asLongText());
			// 其次获取用户的信息
			UserInfo userInfo = userInfoService.getUserInfo(t.getUserId());
			resMap.put("msgType", 1001);
			resMap.put("user", userInfo);
			resMap.put("onLine", channelGroup.size());
			// 上线的人，去除val值
			String userId = TransUtils.mapKeyToStr(onLine,t.getUserId());
			List<UserInfo> userList = userInfoService.getListUserInfo(userId);
			resMap.put("userList", userList != null ? userList : "");
			
			JSONObject json = JSONObject.fromObject(resMap);
			ctx.channel().writeAndFlush(new TextWebSocketFrame(json.toString()));
			Map<String,Object> otherMap = new HashMap<>();
			otherMap.put("msgType", 1002);
			otherMap.put("user", userInfo);
			JSONObject jsons = JSONObject.fromObject(otherMap);
			//告知其他人，有人上线了
			for (Channel channel : channelGroup) {
				if (!channel.id().asLongText().equals(onLine.get(t.getUserId().toString()))) {
					channel.writeAndFlush(new TextWebSocketFrame(jsons.toString()));
				}
			}
			
		} else if(t.getMgsType() == 1003){
			System.out.println("1003...返回聊天记录");
			//接受ID发送
			List<ChatHistory> chatList = chatService.getListChatHistory(t.getUserId(), t.getToUserId());
			//将查出来的的聊天记录返回给点击的那个用户
			Map<String,Object> otherMap = new HashMap<>();
			otherMap.put("msgType", 1003);
			otherMap.put("chatHistory", chatList);
			JSONObject jsons = JSONObject.fromObject(otherMap);
			System.out.println(jsons.toString());
			ctx.channel().writeAndFlush(new TextWebSocketFrame(jsons.toString()));
			
		}else if(t.getMgsType() == 1004){
			System.err.println(t.toString());
			Map<String,Object> chatMap = new HashMap<>();
			chatMap.put("sendUserId", t.getUserId());
			chatMap.put("receiveUserId", t.getToUserId());
			chatMap.put("content", t.getMsg());
			chatMap.put("create_time", TransUtils.getToday());
			int flag = chatService.saveChatHistory(chatMap);
			if (flag > 0) {
				//保存成功,发送给发送给他的人
				Map<String,Object> otherMap = new HashMap<>();
				otherMap.put("msgType", 1004);
				UserInfo userInfo = userInfoService.getUserInfo(t.getUserId());
				userInfo.setSelfIntr(t.getMsg());
				otherMap.put("chatHistory", userInfo);
				JSONObject jsons = JSONObject.fromObject(otherMap);
				//告知她，你发消息
				for (Channel channel : channelGroup) {
					if (channel.id().asLongText().equals(onLine.get(t.getToUserId().toString()))) {
						channel.writeAndFlush(new TextWebSocketFrame(jsons.toString()));
					}
					//返回自己，待定
				}
				
			}else {
				//保存失败，暂不处理
			}
		}else {
			/**
			 * writeAndFlush接收的参数类型是Object类型，但是一般我们都是要传入管道中传输数据的类型，比如我们当前的demo
			 * 传输的就是TextWebSocketFrame类型的数据
			 */

			for (Channel channel : channelGroup) {
				System.out.println("---------------");
				System.out.println(channel.id().asLongText());
				System.out.println(t.getUserId());
				System.out.println("\n");
				if (channel.id().asLongText().equals(t.getUserId())) {
					System.out.println("验证正确");
					channel.writeAndFlush(new TextWebSocketFrame("发送消息-》" + t.getMsg()));
				}
			}
		}

	}

	/**
	 * 
	 * @param c
	 * @param msg
	 * @return
	 */
	public TransMsg transMsg(String msg) {
		TransMsg transMsg = JsonUtils.jsonToBean(msg, TransMsg.class);
		return transMsg;
	}


}
