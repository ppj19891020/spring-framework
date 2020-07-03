package com.learn;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: peijiepang
 * @date 2019-10-09
 * @Description:
 */
public class TranactionApplicationTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TranactionConfig.class);
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		try {
			dataSource.getConnection();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		applicationContext.close();
	}
}
