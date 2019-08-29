package com.learn.controller;

import com.learn.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author: peijiepang
 * @date 2019-08-26
 * @Description:
 */
@Controller
public class TestController {

	/**
	 * 1）@Autowire自动装配：spring规范
	 * 	spring利用依赖注入DI，注入顺序：
	 * 	1. 优先按照bean类型去找组件装配
	 * 	2. 如果找到多个类型一样的bean，则优先按照bean的名称装配
	 * 	3. 使用@Qualifier注解来指定bean组将
	 * 	4. 使用@Primary注解默认使用首选bean
	 *
	 * 	2）java规范 @Resource（JSR250）装配  和 @Inject(JSR330)
	 * 		@Resource：默认根据名称装配，不能支持@Qualifier和@Primary；
	 * 		@Inject：需要导入javax.inject包，和@autowire功能一样
	 *
	 */
	@Qualifier("testDao")
	@Autowired
	private TestDao testDao;

}
