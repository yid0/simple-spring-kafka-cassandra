package com.yidoughi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yidoughi
 */

@ConfigurationProperties
@Getter @Setter
public class ApplicationInfo  {
    @Value("${application.name}")
    private String name;

    @Value("${application.version}")
    private String version;
}
