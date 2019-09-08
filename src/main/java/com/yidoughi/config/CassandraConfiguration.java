package com.yidoughi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * @author yidoughi
 */

@ConfigurationProperties(prefix = "spring.data.cassandra")
@EnableCassandraRepositories
public class CassandraConfiguration  extends AbstractCassandraConfiguration {
    public final Logger log = LoggerFactory.getLogger(CassandraConfiguration.class);

    @Value("${contactPoints}")
    private String contactPoints;

    @Value("${port}")
    private int port;

    @Value("${keyspaceName}")
    private String keySpace;

    @Value("${basePackages}")
    private String basePackages;

    protected String getKeyspaceName() {
        return keySpace;
    }

    public String getContactPoints() {
        return contactPoints;
    }

    protected int getPort() {
        return port;
    }

    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    public String[] getEntityBasePackages() {
        return new String[] {basePackages};
    }
}
