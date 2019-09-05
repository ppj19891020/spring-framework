package com.learn.services;

import org.springframework.stereotype.Component;

/**
 * @author: peijiepang
 * @date 2019-09-05
 * @Description:
 */
@Component
public class MathService {

	public int div(int a,int b){
		return a/b;
	}
}
