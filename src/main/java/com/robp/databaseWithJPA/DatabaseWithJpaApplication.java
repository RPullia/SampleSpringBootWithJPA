package com.robp.databaseWithJPA;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class DatabaseWithJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseWithJpaApplication.class, args);
	}

}
