package com.learn.beanpostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * bean的后置处理器
 * 原理：
 * populateBean  //将bean里的属性复制
 * initialBean{  //初始化Bean对象
 * 		applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName) //执行beanpostprocess的bean初始化前的方法
 *		invokeInitMethods(beanName, wrappedBean, mbd) //执行自定义初始化
 *		applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName) //执行beanpostprocess的初始化后方法
 * }
 *
 * Spring底层对beanpostprocess方法：bean赋值、注入注解、生命周期注解、@Ansy等
 *	1. ApplicationContextAwareProcessor 获取ioc容器
 *	2. BeanValidationPostProcessor 数据校验
 *  3. InitDestroyAnnotationBeanPostProcessor 生命周期注解 @PostConstruct @PreDestroy
 *  4. AutowiredAnnotationBeanPostProcessor 自动注入
 *  5. AsyncAnnotationBeanPostProcessor @Asyn注解
 * @author: peijiepang
 * @date 2019-08-28
 * @Description:
 */
@Component
public class TestBeanPostProcess implements BeanPostProcessor {

	/**
	 * bean初始化之前执行
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("------BeanPostProcessor-postProcessBeforeInitialization...bean+"+bean+" beanName:"+beanName);
		return bean;
	}

	/**
	 * bean初始化之后执行
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("------BeanPostProcessor-postProcessAfterInitialization...bean+"+bean+" beanName:"+beanName);
		return bean;
	}
}
