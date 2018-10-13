package com.sun.learn.handler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.sun.learn.config.RabbitConfig;

@Component
public class BehaviorHandler {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private Logger log = LoggerFactory.getLogger(BehaviorHandler.class);

	@RabbitListener(queues = { RabbitConfig.BEHAVIOR_COLLECTION_NAME })
	public void listenerBehavior(String msg, Message message, Channel channel) {
		log.info("[ behavior_collection 监听的消息] - [{}]", msg.toString());
		try {
			// 1保存数据库操作
			// 2通知 MQ 消息已被成功消费,可以ACK了
			String sql = "INSERT INTO behavior (msg, update_time) VALUES ('" + msg + "','" + getDateAndTime() + "')";
			System.out.println(jdbcTemplate.update(sql));
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		} catch (IOException e) {
			// 3如果报错了,那么我们可以进行容错处理,比如转移当前消息进入其它队列
		}
	}

	public static String getDateAndTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(cal.getTime());
	}
}
