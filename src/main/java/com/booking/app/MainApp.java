package com.booking.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.booking.repository")
@ComponentScan("com.booking")
public class MainApp {
    public static void main(String args[]){
        SpringApplication.run(MainApp.class,args);
    }
}
