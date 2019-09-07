package com.yidoughi.domain;

import com.datastax.driver.core.DataType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@Getter @Setter
@Table(value = "message")
public class Message implements Serializable {

    @CassandraType(type = DataType.Name.UUID)
    @PrimaryKey
    @Getter
    private MessageKey id;
    private String body;
    private Map<String, String> otherData = new HashMap<>();
    @Getter
    private Date sent_at;

    public String getBody() {
        return body;
    }

    public Date getSent_at() {
        return sent_at;
    }
}
