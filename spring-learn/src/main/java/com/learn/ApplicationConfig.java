package com.learn;

import com.learn.bean.Person;
import com.learn.services.CacheService;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author: peijiepang
 * @date 2019-08-14
 * @Description:
 */
@EnableCaching
@Configuration
public class ApplicationConfig {

	@Bean("cacheManager")
	public SimpleCacheManager cacheManager(){
		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
		simpleCacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("test")));
		return simpleCacheManager;
	}


	@Bean(name = "zhangsan")
	public Person zhangsan() {
	   return new Person("zhangsan",12);
	}

	@Bean(name = "lisi")
	public Person lisi() {
		return new Person("lisi",16);
	}

	@Bean
	public CacheService cacheService(){
		return new CacheService();
	}
}
