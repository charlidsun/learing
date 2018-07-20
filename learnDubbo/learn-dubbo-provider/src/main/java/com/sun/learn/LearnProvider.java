 package com.sun.learn;

import java.util.concurrent.CountDownLatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * 功能：提供者，提供接口实现方法
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月19日 上午9:57:49
 */
@SpringBootApplication
//开启dubbo
@EnableDubboConfiguration
public class LearnProvider {
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(LearnProvider.class, args);
		//因为没有容器，使用这种方式可以保持一直运行
		new CountDownLatch(1).await();
	}
}
