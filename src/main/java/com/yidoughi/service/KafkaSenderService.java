package com.yidoughi.service;

import com.yidoughi.dto.MessageDTO;
import com.yidoughi.respository.MessageRepository;
import com.yidoughi.rest.mapper.MessgeMapper;
import org.apache.kafka.common.KafkaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.CassandraInternalException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author yidoughi
 */

@Service
public class KafkaSenderService {
    private final Logger log = LoggerFactory.getLogger(KafkaSenderService.class);
    private final String  TOPIC = "test-topic";

    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Autowired
    private MessageRepository messageRepository;

    public void sendMessage(MessageDTO message) {
        try {
            kafkaTemplate.send(TOPIC, message.toString());
            log.debug("New Kakfa message :", message.toString());
            messageRepository.save(MessgeMapper.toMessage(message));
        }catch (KafkaException e) {
            log.error(e.getMessage());
        }catch (CassandraInternalException e) {
            log.error(e.getMessage());
        }
    }
}
