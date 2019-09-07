package com.yidoughi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SimpleKafka {

    public static void main ( String [] args) {
        SpringApplication.run(SimpleKafka.class, args);
    }
}
