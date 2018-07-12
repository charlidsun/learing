package com.sun.nettyLearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.nettyLearning.wb.WbServer;

@Controller
@SpringBootApplication
public class NettyLearningApplication implements CommandLineRunner{
	
	@RequestMapping("/hello")
	public String hello(){
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(NettyLearningApplication.class, args);
	}
	
	@Autowired
	private WbServer wbServer;

	@Bean
	public WbServer chatServer() {
		return new WbServer();
	}

	@Override
	public void run(String... args) throws Exception {
		wbServer.run();
	}
}
