package com.test.springboot.user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@SpringBootApplication
public class UserManagementApp {

    public static void main(String... args) {
        SpringApplication.run(UserManagementApp.class, args);
    }

}
