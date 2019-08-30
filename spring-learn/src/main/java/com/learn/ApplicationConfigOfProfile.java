package com.learn;

import com.learn.bean.Person;
import com.learn.bean.Person1;
import com.learn.bean.Person2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author: peijiepang
 * @date 2019-08-30
 * @Description:
 */
@Configuration
public class ApplicationConfigOfProfile {

	@Profile("dev")
	@Bean
	public Person person(){
		return new Person();
	}

	@Profile("test")
	@Bean
	public Person1 person1(){
		return new Person1();
	}

	@Profile("default")
	@Bean
	public Person2 person2(){
		return new Person2();
	}}
