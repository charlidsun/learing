package com.sun.learnMybatisXml.util;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

public class RedisUtil {

	// 使用redisTemplate
	private RedisTemplate<String, Object> redisTemplate;

	public RedisUtil(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	/**
	 * 指定缓存失效时间
	 * 
	 * @param key
	 * @param time
	 * @return
	 */
	public boolean expire(String key, long time) {
		try {
			if (time > 0) {
				redisTemplate.expire(key, time, TimeUnit.SECONDS);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据key获取失效时间，如果为null返回-1
	 * 
	 * @param key
	 * @return
	 */
	public long getExpire(String key) {
		if (key == null)
			return -1;
		return redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}

	/**
	 * 判断缓存里是否存在
	 * 
	 * @param key
	 * @return
	 */
	public boolean hasKey(String key) {
		try {
			return redisTemplate.hasKey(key);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据key删除值
	 * 
	 * @param strings
	 */
	@SuppressWarnings("unchecked")
	public void delete(String... strings) {
		if (strings != null && strings.length > 0) {
			if (strings.length == 1) {
				redisTemplate.delete(strings[0]);
			} else {
				redisTemplate.delete(CollectionUtils.arrayToList(strings));
			}
		}
	}

	/**
	 * 根据key获取值
	 * 
	 * @param key
	 * @return
	 */
	public Object getByKey(String key) {
		return key == null ? key : redisTemplate.opsForValue().get(key);
	}

	/**
	 * 根据key设置值
	 * 
	 * @param key
	 * @param val
	 * @return
	 */
	public boolean setByKey(String key, String val) {
		if (key == null || val == null)
			return false;
		try {
			redisTemplate.opsForValue().set(key, val);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据key设置值，并设置时间，如果时间为0，则为永久时间
	 * 
	 * @param key
	 * @param val
	 * @param time
	 * @return
	 */
	public boolean setByKey(String key, String val, long time) {
		if (key == null || val == null)
			return false;
		try {
			if (time > 0)
				redisTemplate.opsForValue().set(key, val, time, TimeUnit.SECONDS);
			else
				redisTemplate.opsForValue().set(key, val);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 递增
	 * @param key
	 * @param delta 递增因子 大于0
	 * @return
	 */
	public long increment(String key, long delta) {
		if (delta < 0) {
			throw new RuntimeException("递增因子必须大于0");
		}
		return redisTemplate.opsForValue().increment(key, delta);
	}
	
	/**
	 * 递增
	 * @param key
	 * @param delta 递增因子 大于0
	 * @return
	 */
	public long decrease(String key,long decr) {
		if (decr < 0) {
			throw new RuntimeException("递增因子必须大于0");
		}
		return redisTemplate.opsForValue().increment(key, -decr);
	}
	
	/**
	 * 根据key和hashKey得到值
	 * @param key
	 * @param hashKey
	 * @return
	 */
	public Object getHashByKeyAndKey(String key,String hashKey) {
		return redisTemplate.opsForHash().get(key, hashKey);
	}
	
	/**
	 * 根据key获取所有值
	 * @param key
	 * @return
	 */
	public Map<Object,Object> getHashByKey(String key){
		return redisTemplate.opsForHash().entries(key);
	}
	
	
}
