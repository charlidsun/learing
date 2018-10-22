package com.sun.permission.common.config.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2//开启
public class SwaggerConfig {
	
	@Autowired
	Environment env;
	
	//创建
    @Bean
	public Docket createRestApi() {
		
    	 Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
        	 @Override
             public boolean apply(RequestHandler input) {
                 // 除非是在开发环境中否则不开启swagger2
                 String active = env.getProperty("spring.profiles.active");
                 if(!active.equalsIgnoreCase("dev")){
                     return false;
                 }
                 Class<?> declaringClass = input.declaringClass();
                 if (declaringClass == BasicErrorController.class)// 排除
                     return false;
                 if(declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
                     return true;
                 if(input.isAnnotatedWith(ResponseBody.class)) // 被注解的方法
                     return true;
                 return false;
             }
        };
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(predicate)
                .build();

	}
	
	//创建该Api的基本信息
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("test").version("1.0").build();
	}
}
