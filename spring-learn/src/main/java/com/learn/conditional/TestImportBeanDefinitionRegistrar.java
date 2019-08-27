package com.learn.conditional;

import com.learn.bean.Person1;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: peijiepang
 * @date 2019-08-27
 * @Description:
 */
public class TestImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * 自定义注册bean
	 * @param importingClassMetadata annotation metadata of the importing class
	 * @param registry current bean definition registry 注册类信息
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		if(!registry.containsBeanDefinition("beanDefinition")) {
			BeanDefinition beanDefinition = new RootBeanDefinition(Person1.class);
			registry.registerBeanDefinition("beanDefinition", beanDefinition);
		}
	}
}
