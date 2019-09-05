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
