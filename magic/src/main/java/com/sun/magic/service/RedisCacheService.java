package com.sun.magic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 功能： 说明：
 * 
 * @author 孙荆阁:
 * @Date 2018年7月27日 下午5:50:29
 */
@Service
public class RedisCacheService {

	@Autowired
	private JedisPool jedisPool;

	public String getToken() {
		String token = "";
		try (Jedis jedis = jedisPool.getResource()) {
			token = jedis.get("token");
		}
		return token;
	}
}
