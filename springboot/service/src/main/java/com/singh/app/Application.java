package com.singh.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication(scanBasePackages= {"com.singh"})
@EntityScan( basePackages = {"com.singh.model"} )
@EnableJpaRepositories("com.singh.dao")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
