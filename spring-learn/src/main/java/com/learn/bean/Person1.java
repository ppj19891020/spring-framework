package com.learn.bean;

/**
 * @author: peijiepang
 * @date 2019-08-14
 * @Description:
 */
public class Person1 {

	public Person1() {

	}

	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	private String name;

	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
