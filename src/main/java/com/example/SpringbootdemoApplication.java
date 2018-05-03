package com.example;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * 入口
 *  SpringBootApplication 相当于@Configuration @ComponentScan @EnableAutoConfiguration
 */
@SpringBootApplication
@MapperScan("com.example.mapper")
public class SpringbootdemoApplication extends SpringBootServletInitializer{

	/**
	 * Servlet支持
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootdemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}


}
