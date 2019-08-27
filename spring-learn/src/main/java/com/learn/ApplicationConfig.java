package com.learn;

import com.learn.bean.Person;
import com.learn.bean.TestFactoryBean;
import com.learn.conditional.TestConditions;
import com.learn.conditional.TestImportBeanDefinitionRegistrar;
import com.learn.conditional.TestImportSelect;
import com.learn.services.CacheService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

/**
 * @author: peijiepang
 * @date 2019-08-14
 * @Description:
 */
//spring 缓存配置
@EnableCaching
//配置类==配置文件
@Configuration
//扫描包配置
@ComponentScans(
		value = {
				//包扫描注解,excludeFilters排除类
				@ComponentScan(basePackages = {"com.learn"},useDefaultFilters = true,excludeFilters = {
				//指定规则排除类
				//@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
				},includeFilters = {
						//指定扫描的时候只需要包含,要使用该方法，需要配置useDefaultFilters = false
						@ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={Controller.class})
				})
		}
)
/**
 * 给容器注入bean组件：
 * 1. 包扫描+注解 @Controller、@Service、@Compent等等
 * 2. @Bean 注入
 * 3. @Import
 * 		3.1 @Import(组件bean class)
 * 		3.2 ImportSelect 接口组件
 * 		3.3 ImportBeanDefinitionRegistrar 接口组件
 * 		3.4 使用factorybean
 */
@Import({Person.class, TestImportSelect.class, TestImportBeanDefinitionRegistrar.class})
public class ApplicationConfig {

	@Bean("cacheManager")
	public SimpleCacheManager cacheManager(){
		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
		simpleCacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("test")));
		return simpleCacheManager;
	}

	//单例/多实例
	@Scope(value = "singleton")
	//懒加载：指在使用的时候创建对象，只能适合单实例
	@Lazy
	//给容器注册一个bean，类型为返回值的类型，方法名就是bean的id
	@Bean(name = "zhangsan")
	public Person zhangsan() {
	   return new Person("zhangsan",12);
	}

	// 条件注入
	@Conditional(value = {TestConditions.class})
	@Bean(name = "lisi")
	public Person lisi() {
		return new Person("lisi",16);
	}

	@Bean
	public Person person() {
		return new Person("person",16);
	}

	@Bean
	public CacheService cacheService(){
		return new CacheService();
	}

	/**
	 * factory bean工厂生产bean
	 * @return
	 */
	@Bean
	public TestFactoryBean testFactoryBean(){
		return new TestFactoryBean();
	}
}
