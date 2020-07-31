package com.learn;

import com.learn.bean.CyclicBean1;
import com.learn.bean.CyclicBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: peijiepang
 * @date 2020/7/31
 * @Description:
 */
@Configuration
public class CyclicConfig {

	@Bean
	public CyclicBean1 cyclicBean1(){
		return new CyclicBean1();
	}

	@Bean
	public CyclicBean2 cyclicBean2(){
		return new CyclicBean2();
	}

}
