package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.meal_ordering_system.dao")
public class MealOrderingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MealOrderingSystemApplication.class, args);
    }

}
