package com.learn;

import com.learn.services.MathService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: peijiepang
 * @date 2019-09-05
 * @Description:
 */
public class AopApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AopApplicationConfig.class);
		MathService mathService = annotationConfigApplicationContext.getBean(MathService.class);
		Integer i = mathService.div(21,1);
		annotationConfigApplicationContext.close();
	}
}
