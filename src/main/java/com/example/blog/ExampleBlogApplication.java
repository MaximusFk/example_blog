package com.example.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:hibernate_bean_config.xml")
public class ExampleBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleBlogApplication.class, args);
	}
}