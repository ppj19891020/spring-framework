package com.learn.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: peijiepang
 * @date 2019-08-30
 * @Description:
 */
@Component
public class Boss {

//	@Autowired
	private Person person;

	@Autowired
	public Boss(@Autowired Person person){
		this.person =person;
		System.out.println("Boss:"+person.toString());
	}

	public void test(Person1 person1){
		System.out.println("Boss:"+person1.toString());
	}

}
