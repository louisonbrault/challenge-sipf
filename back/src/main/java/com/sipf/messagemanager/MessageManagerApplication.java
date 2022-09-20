package com.sipf.messagemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MessageManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageManagerApplication.class, args);
	}

}
