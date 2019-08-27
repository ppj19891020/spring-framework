package com.learn.conditional;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 测试conditional
 * @author: peijiepang
 * @date 2019-08-27
 * @Description:
 */
public class TestConditions implements Condition {

	/**
	 *
	 * @param context the condition context
	 * @param metadata metadata of the {@link org.springframework.core.type.AnnotationMetadata class}
	 * or {@link org.springframework.core.type.MethodMetadata method} being checked 注释信息
	 * @return
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//获取beanfactory
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		//获取环境变量
		Environment environment = context.getEnvironment();
		//获取bean注册信息
		BeanDefinitionRegistry beanDefinitionRegistry =context.getRegistry();
		if(beanDefinitionRegistry.containsBeanDefinition("zhangsan111")){
			return true;
		}
		return false;
	}
}
