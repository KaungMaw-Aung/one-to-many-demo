package com.example.onetomanytest;

import com.example.onetomanytest.service.IDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToManyTestApplication {

    @Autowired
    IDatabase iDatabase;

    public static void main(String[] args) {
        SpringApplication.run(OneToManyTestApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(){
        return args -> {
            iDatabase.createDatabase();
        };
    }

}
