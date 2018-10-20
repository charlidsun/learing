package com.sun.learnMybatisXml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//开启spring缓存
@EnableCaching
public class LearnMybatisXmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnMybatisXmlApplication.class, args);
	}
}
