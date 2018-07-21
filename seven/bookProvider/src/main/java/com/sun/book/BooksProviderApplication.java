 package com.sun.book;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.JdbcTransactionObjectSupport;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月21日 下午1:51:58
 */
@SpringBootApplication
@EnableDubboConfiguration
public class BooksProviderApplication {
	
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(BooksProviderApplication.class, args);
		new CountDownLatch(1).await();
	}
}
