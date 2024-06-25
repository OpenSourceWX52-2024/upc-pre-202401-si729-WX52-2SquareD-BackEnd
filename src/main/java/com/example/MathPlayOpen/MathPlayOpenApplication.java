package com.example.MathPlayOpen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.example.MathPlayOpen", "com.example.MathPlayOpen.iam"})
public class MathPlayOpenApplication {

	public static void main(String[] args) {
		SpringApplication.run(MathPlayOpenApplication.class, args);
	}

}
