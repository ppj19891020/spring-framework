package com.learn.services;

import org.springframework.cache.annotation.Cacheable;

/**
 * @author: peijiepang
 * @date 2019-08-19
 * @Description:
 */
public class CacheService {

	@Cacheable(cacheNames = "test",key="#test")
	public long getTime(String test) {
		return System.currentTimeMillis();
	}

}
