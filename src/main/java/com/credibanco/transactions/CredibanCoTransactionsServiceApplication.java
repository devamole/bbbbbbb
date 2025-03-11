package com.credibanco.transactions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CredibanCoTransactionsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CredibanCoTransactionsServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner startupMessage() {
		return args -> System.out.println("CredibanCo Transactions Service started successfully.");
	}
}
