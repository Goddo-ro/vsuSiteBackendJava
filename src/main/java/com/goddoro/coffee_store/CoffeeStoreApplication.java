package com.goddoro.coffee_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CoffeeStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoffeeStoreApplication.class, args);
    }
}
