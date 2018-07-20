package com.sun.mqLearn.handler;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.sun.mqLearn.config.RabbitConfig;
import com.sun.mqLearn.entity.UserInfo;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月20日 上午10:42:25
 */
@Component
public class RabbitHanlder {

	private static final Logger log = LoggerFactory.getLogger(RabbitHanlder.class);
	
	@RabbitListener(queues={RabbitConfig.DETAULT_BOOK_QUEUE})
	public void listenAutoAck(UserInfo u,Message message,Channel channel){
		final long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            log.info("[listenerAutoAck 监听的消息] - [{}]", u.toString());
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            try {
                // TODO 处理失败,重新压入MQ
                channel.basicRecover();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
	}
	
	@RabbitListener(queues = {RabbitConfig.MANUAL_BOOK_QUEUE})
    public void listenerManualAck(UserInfo u, Message message, Channel channel) {
        log.info("[listenerManualAck 监听的消息] - [{}]", u.toString());
        try {
            //通知 MQ 消息已被成功消费,可以ACK了
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            // 如果报错了,那么我们可以进行容错处理,比如转移当前消息进入其它队列
        }
    }
}
