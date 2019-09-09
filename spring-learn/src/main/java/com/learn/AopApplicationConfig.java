package com.learn;

import com.learn.aop.LogAspect;
import com.learn.services.MathService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * aop 配置类
 * AOP：程序运行期间动态的将某段代码切入到指定代码中，原理就是动态代理
 * 1. 导入aop模块，引入 spring-aspects
 * 2. 定义日志切面类logaspect，然后定义通知方法
 * 		2.1 前置通知
 * 		2.2 后置通知
 * 		2.3 返回通知
 * 		2.4 异常通知
 * 		2.5 环绕通知
 * 3. 给切面类定义什么时候运行（通知注解）
 * 4. 将切面类和目标方法都加入到spring容器中
 * 5. 切面类使用@Aspect注解
 * 6. 开启基于注解版的切面功能@EnableAspectJAutoProxy(
 *
 *
 * AOP 原理：
 *	1. @EnableAspectJAutoProxy()是什么？
 * 		@Import(AspectJAutoProxyRegistrar.class) 给容器导入AspectJAutoProxyRegistrar
 * 			利用AspectJAutoProxyRegistrar给容器注册，通过实现 ImportBeanDefinitionRegistrar 导入bean
 * 				注册bean AnnotationAwareAspectJAutoProxyCreator bean名为internalAutoProxyCreator
 * 2. AnnotationAwareAspectJAutoProxyCreator
 * 		-> AspectJAwareAdvisorAutoProxyCreator
 * 			-> AbstractAdvisorAutoProxyCreator
 * 				-> 	AbstractAutoProxyCreator
 * 					implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 * 						-> InstantiationAwareBeanPostProcessor
 * 							-> BeanPostProcessor
 * 								BeanPostProcessor 初始化前后做事情
 * 								BeanFactoryAware 自定装配beanfactory
 *
 *
 * AOP（AnnotationAwareAspectJAutoProxyCreator）创建和注册流程：
 * 	1. 传入主配置类，创建ioc容器；
 *	2. 注册配置类，调用refresh方法；
 *	3. registerBeanPostProcessors(beanFactory) 注册bean的后置处理器来方便拦截bean的创建
 *		3.1 beanFactory.getBeanNamesForType(BeanPostProcessor.class, true, false); 先获取ioc容器已经定义的BeanPostProcessor；
 *		3.2 beanFactory.addBeanPostProcessor(new BeanPostProcessorChecker(beanFactory, beanProcessorTargetCount)); 给容器加入别的beanpostprocessor；
 *		3.3 优先注册了实现PriorityOrdered的接口
 *		3.4 在注册实现Ordered的接口
 *		3.5 最后注册没有实现接口的benapostprocessor
 *		3.6 注册beanpostprocessor，beanFactory.getBean(ppName, BeanPostProcessor.class);
 *			3.6.1 createBean(beanName, mbd, args) --> createBeanInstance(beanName, mbd, args) 创建bean实例；
 *			3.6.2 bean 属性赋值  populateBean(beanName, mbd, instanceWrapper);
 *			3.6.3 初始化bean  initializeBean(beanName, exposedObject, mbd);
 *				3.6.3.1 Aware接口的方法回调 invokeAwareMethods(beanName, bean);
 *				3.6.3.2 应用后置处理器的postprocessorsbeforeinitialization调用入口 applyBeanPostProcessorsBeforeInitialization
 *				3.6.3.2 初始自定义初始化方法  invokeInitMethods(beanName, wrappedBean, mbd);
 *				3.6.3.3 应用后置处理器after方法  applyBeanPostProcessorsAfterInitializatio；
 *		4. beanpostprocessor（AnnotationAwareAspectJAutoProxyCreator)创建完成	 initBeanFactory((ConfigurableListableBeanFactory) beanFactory);
 *			4.1 this.aspectJAdvisorFactory = new ReflectiveAspectJAdvisorFactory(beanFactory);
 *			4.2	new BeanFactoryAspectJAdvisorsBuilderAdapter(beanFactory, this.aspectJAdvisorFactory)
 * 4. 把beanpostprocessor添加到beanfactory中 orderedPostProcessorNames.add(ppName);
 *
 *
 * AnnotationAwareAspectJAutoProxyCreator--->SmartInstantiationAwareBeanPostProcessor--->InstantiationAwareBeanPostProcessor
 *	1. finishBeanFactoryInitialization(beanFactory); 初始化所有剩余的单例 Bean
 *	2. beanFactory.preInstantiateSingletons(); 初始化剩余的bean
 *	3. 遍历所有的bean，依次创建对象getBean(name) --> doGetBean() --> singletonFactory.getObject();
 *	4. 创建bean
 *		4.1 先从缓存中获取bean,如果能找到缓存，则说明该bean已经被创建过，直接使用，否则在创建；只要创建bean都会被缓存；
 *		4.2 createBean()创建bean
 *			4.2.1 resolveBeforeInstantiation 给beanpostprocessor一个机会创建代理对象，如果能返回，直接用代理对象；如果不能返回，则直接doCreateBean(beanName, mbdToUse, args);
 *			4.2.2  applyBeanPostProcessorsBeforeInstantiation(targetType, beanName);拿到InstantiationAwareBeanPostProcessor后置处理器，然后执行postProcessBeforeInstantiation方法；
 *				  applyBeanPostProcessorsAfterInitialization(bean, beanName);
 * InstantiationAwareBeanPostProcessor 和 BeanPostprocessor区别：
 * BeanPostprocessor:在bean对象初始化前后调用；
 * InstantiationAwareBeanPostProcessor：是在bean实例化之前尝试后置处理器返回代理对象；
 *
 *
 * @author: peijiepang
 * @date 2019-09-05
 * @Description:
 */
@EnableAspectJAutoProxy()
@Configuration
public class AopApplicationConfig {

	@Bean
	public MathService mathService(){
		return new MathService();
	}

	@Bean
	public LogAspect logAspect(){
		return new LogAspect();
	}

}
