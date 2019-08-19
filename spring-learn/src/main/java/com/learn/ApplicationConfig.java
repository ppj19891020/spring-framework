package com.learn;

import com.learn.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: peijiepang
 * @date 2019-08-14
 * @Description:
 */
@Configuration
public class ApplicationConfig {

	@Bean(name = "zhangsan")
	public Person zhangsan() {
	   return new Person("zhangsan",12);
	}

	@Bean(name = "lisi")
	public Person lisi() {
		return new Person("lisi",16);
	}

}
