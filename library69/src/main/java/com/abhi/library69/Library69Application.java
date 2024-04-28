package com.abhi.library69;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Library69Application implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(Library69Application.class, args);
	}

	@Autowired
	ApplicationContext context;

	@Value("${a}")
	Integer a = 5;

	@Override
	public void run(String... args) throws Exception {

		/** we can interact with Spring using this class**/
//		for(String beanName : context.getBeanDefinitionNames()){
//			System.out.println("Bean Name : "+beanName);
//		}

		System.out.println(a);
	}
}
