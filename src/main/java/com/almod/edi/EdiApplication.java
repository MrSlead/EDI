package com.almod.edi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class EdiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdiApplication.class, args);
	}

}
