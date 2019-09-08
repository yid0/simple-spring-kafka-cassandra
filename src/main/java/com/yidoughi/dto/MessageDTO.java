package com.yidoughi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter @Setter
public class MessageDTO {
    private String id;
    private String content;
    private String topic;
    private Map<String, String> otherData;
    private Date createdAt;

    public String toString() {
        return "MessageDTO{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", otherData=" + otherData +
                ", createdAt=" + createdAt +
                '}';
    }
}
