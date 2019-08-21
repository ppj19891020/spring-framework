package com.learn;

import com.learn.services.CacheService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: peijiepang
 * @date 2019-08-14
 * @Description:
 */
public class ApplicationTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		CacheService cacheService = context.getBean(CacheService.class);
		cacheService.getTime("aaa");
		cacheService.getTime("aaa");
		context.close();
	}
}
