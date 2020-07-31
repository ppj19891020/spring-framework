package com.learn.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: peijiepang
 * @date 2020/7/31
 * @Description:
 */
public class CyclicBean1 {

	@Autowired
	private CyclicBean2 cyclicBean2;

}
