package com.petitions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Точка входу в Spring Boot застосунок.
 * @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
 */
@SpringBootApplication
public class PetitionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetitionApplication.class, args);
    }
}
