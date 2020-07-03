package com.learn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author: peijiepang
 * @date 2019-08-26
 * @Description:
 */
@Repository
public class TestDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insert(){

	}

}
