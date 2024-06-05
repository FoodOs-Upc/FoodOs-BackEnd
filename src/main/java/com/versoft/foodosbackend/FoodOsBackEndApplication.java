package com.versoft.foodosbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FoodOsBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodOsBackEndApplication.class, args);
    }

}
