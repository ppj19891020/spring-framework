package com.learn.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 工厂bean
 * @author: peijiepang
 * @date 2019-08-27
 * @Description:
 */
public class TestFactoryBean implements FactoryBean<Person2> {
	@Override
	public Person2 getObject() throws Exception {
		return new Person2();
	}

	/**
	 * bean 类型
	 * @return
	 */
	@Override
	public Class<?> getObjectType() {
		return Person2.class;
	}

	/**
	 * 是否单例
	 * @return
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}
}
