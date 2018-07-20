package com.sun.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月19日 上午10:13:01
 */
@SpringBootApplication
//使用dubbospringboot，开启
@EnableDubboConfiguration
public class LearnConsumer {

	public static void main(String[] args) {
		SpringApplication.run(LearnConsumer.class, args);
	}
}
