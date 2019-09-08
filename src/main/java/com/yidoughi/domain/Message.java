package com.yidoughi.domain;

import com.datastax.driver.core.DataType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@Getter @Setter
@Table(value = "message")
public class Message implements Serializable {

    @CassandraType(type = DataType.Name.UUID)
    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    private UUID id;

    private String content;

    private String topic;

    @Column(value = "other_data")
    private Map<String, String> otherData = new HashMap<>();

    @Column(value = "sent_at")
    private Date sentAt;

    public Message() {
        this.id = UUID.randomUUID();
        this.setSentAt(new Date());
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", topic='" + topic + '\'' +
                ", otherData=" + otherData +
                ", sentAt=" + sentAt +
                '}';
    }
}
