package com.learn;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: peijiepang
 * @date 2019-10-09
 * @Description:
 */
@Configuration
//@EnableTransactionManagement
public class TranactionConfig {

	@Value("test.prop")
	private String testProp;

	@Bean
	public DataSource dataSource(){
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUrl("jdbc:127.0.0.1:3306/test");
		druidDataSource.setUsername("root");
		druidDataSource.setPassword("123456");
		return druidDataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}

//	@Bean
//	public PlatformTransactionManager transactionManager(){
//		return new DataSourceTransactionManager(dataSource());
//	}

}
