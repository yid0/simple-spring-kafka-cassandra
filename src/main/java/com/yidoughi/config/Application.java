package com.yidoughi.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Configuration
@Getter @Setter
public class Application implements Serializable {

    @Value("${application.name}")
    private String name;

    @Value("${application.version}")
    private String version;
}
