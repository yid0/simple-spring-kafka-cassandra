package com.yidoughi.service;

import com.yidoughi.domain.Message;
import org.apache.kafka.common.KafkaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * @author yidoughi
 */

@Service
public class KafkaSenderService {
    private final Logger log = LoggerFactory.getLogger(KafkaSenderService.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;
    public void sendMessage(Message message) {
        try {
            kafkaTemplate.send("test-topic", message.getBody());
        }catch (KafkaException e) {
            log.debug(e.getMessage());
        }
    }
    public void sendMessage( Map<String, ?> message) {
        try {
            kafkaTemplate.send("test-topic", message.get("nhits").toString());
        }catch (KafkaException e) {
            log.debug(e.getMessage());
        }
    }
}
