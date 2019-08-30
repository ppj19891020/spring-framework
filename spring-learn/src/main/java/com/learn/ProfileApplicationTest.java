package com.learn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Profile :指定组件在哪个环境下才能注册到容器中，如果不指定，任何容器都能注册这个组件
 * 1) 增加了@Profile的注解的bean，只有这个环境被激活之后才能注册到这个容器中，默认是default环境
 * 2）写在配置类上，只有指定环境，整个配置类才能生效；
 * 3）没有@Profile注解的bean，任何环境都会加载；
 * @author: peijiepang
 * @date 2019-08-30
 * @Description:
 */
public class ProfileApplicationTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.getEnvironment().setActiveProfiles("test");
		annotationConfigApplicationContext.register(ApplicationConfigOfProfile.class);
		annotationConfigApplicationContext.refresh();

		String[] names = annotationConfigApplicationContext.getBeanDefinitionNames();
		for(String name:names){
			System.out.println(name);
		}
		annotationConfigApplicationContext.close();
	}

}
