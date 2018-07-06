package com.sun.shiroLearning.config;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能：
 * 说明：
 * @author 孙荆阁:
 * @Date 2018年7月6日 上午10:56:28
 */
@Configuration
public class ShiroConfiguration {

	@Bean
	public EhCacheManager getEhCacheManager(){
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
		return cacheManager;
	}
	
	@Bean
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor(){
		return new LifecycleBeanPostProcessor();
	}
	
	@Bean
	public DefaultAdvisorAutoProxyCreator getAdvisorAutoProxyCreator(){
		DefaultAdvisorAutoProxyCreator c = new DefaultAdvisorAutoProxyCreator();
		c.setProxyTargetClass(true);
		return c;
	}
	
	@Bean(name="authRealm")
	public AuthRealm authRealm(EhCacheManager cacheManager){
		AuthRealm authRealm = new 
	}
	
	
}
