package com.prakritidev.verma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnigSpringJavaDataStructuresApplication {

	public static void main(String[] args) {


		Thread thread = new Thread();
		thread.start();
		
		SpringApplication.run(LearnigSpringJavaDataStructuresApplication.class, args);
	}

}