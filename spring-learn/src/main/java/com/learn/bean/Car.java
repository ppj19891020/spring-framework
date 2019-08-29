package com.learn.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: peijiepang
 * @date 2019-08-28
 * @Description:
 */
public class Car implements InitializingBean, DisposableBean {

	/**
	 * @Value使用
	 * 1. 直接写数值
	 * 2. 可以用springel表达式，#{}
	 * 3. 可以用环境变量中的是，${}
	 */
	@Value("test.name")
	private String name;

	public Car() {
		System.out.println("----构造函数");
	}

	public void init(){
		System.out.println("----初始化init");
	}

	public void destory(){
		System.out.println("----销毁destory");
	}

	@PostConstruct
	public void postConstruct(){
		System.out.println("-----初始化postconstuct");
	}

	@PreDestroy
	public void preDestory(){
		System.out.println("-----销毁preDestory");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("----销毁DisposableBean");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("----初始化InitializingBean");
	}
}
