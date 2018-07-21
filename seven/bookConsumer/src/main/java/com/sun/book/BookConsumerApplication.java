package com.sun.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月21日 下午2:06:12
 */
@SpringBootApplication
@EnableDubboConfiguration
public class BookConsumerApplication {
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(BookConsumerApplication.class, args);
	}
}
