package com.yidoughi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Arrays;
import java.util.List;

/**
 * @author yidoughi
 */

@ConfigurationProperties(prefix = "spring.data.cassandra")
@EnableCassandraRepositories
public abstract class CassandraConfiguration  extends AbstractCassandraConfiguration {
    public final Logger log = LoggerFactory.getLogger(CassandraConfiguration.class);

    @Value("${contactPoints}")
    private String contactPoints;

    @Value("${port}")
    private int port;

    @Value("${keyspaceName}")
    private String keySpace;

    @Value("${basePackages}")
    private String basePackages;

    @Override
    protected List<String> getStartupScripts() {
        final String script =
                "CREATE KEYSPACE IF NOT EXISTS "
                        + keySpace
                        + " WITH durable_writes = true"
                        + " AND replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1};";
        return Arrays.asList(script);
    }

    @Override
    public String getKeyspaceName() {
        return keySpace;
    }
    @Override
    public String getContactPoints() {
        return contactPoints;
    }
    @Override
    protected int getPort() {
        return port;
    }
    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }
    @Override
    public String[] getEntityBasePackages() {
        return new String[] {basePackages};
    }
}
