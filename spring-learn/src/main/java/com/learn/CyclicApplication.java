package com.learn;

import com.learn.bean.CyclicBean1;
import com.learn.bean.CyclicBean2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: peijiepang
 * @date 2020/7/31
 * @Description:
 */
public class CyclicApplication {

	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CyclicConfig.class);
		CyclicBean1 cyclicBean1 = applicationContext.getBean(CyclicBean1.class);
		CyclicBean2 cyclicBean2 = applicationContext.getBean(CyclicBean2.class);
	}

}
