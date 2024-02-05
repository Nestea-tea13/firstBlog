package com.exampleblog.firstblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages={"com.*"})
public class FirstblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstblogApplication.class, args);
	}

}
