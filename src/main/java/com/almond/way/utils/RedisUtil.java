package com.almond.way.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public final class RedisUtil {
	
	private static JedisPool jedisPool = null;
	private static Jedis jedis = null;
	
	static {
		jedis = new Jedis();
	}
	
	public String getStringValue(String key) {
		return jedis.get(key);
	}
	
	public void setStringValue(String key, String value) {
		jedis.set(key, value);
	}
	

}
