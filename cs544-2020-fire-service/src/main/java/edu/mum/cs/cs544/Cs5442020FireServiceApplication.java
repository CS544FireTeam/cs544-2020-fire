package edu.mum.cs.cs544;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Cs5442020FireServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cs5442020FireServiceApplication.class, args);
	}

}
