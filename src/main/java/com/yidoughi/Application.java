package com.yidoughi;

import com.yidoughi.config.ApplicationInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = ApplicationInfo.class)
public class Application {

    public static void main ( String [] args) {
        SpringApplication.run(Application.class, args);
    }
}
