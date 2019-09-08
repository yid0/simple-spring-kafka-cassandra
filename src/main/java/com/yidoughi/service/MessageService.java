package com.yidoughi.service;

import com.yidoughi.domain.Message;
import com.yidoughi.dto.MessageDTO;
import com.yidoughi.respository.MessageRepository;
import com.yidoughi.rest.mapper.MessgeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author yidoughi
 *
 */

@Service
public class MessageService {
    private final Logger log = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    public MessageRepository messageRepository;

    public Message retreiveMessage(String id) {
        log.debug("Find message : ", id);
        return messageRepository.findOneById(UUID.fromString(id));
    }
    public List<MessageDTO> getAllMessages () {
        log.info("Get all messages waiting ...");
        List<Message> messages =  messageRepository.findAll();
        return messages.stream().map(message -> MessgeMapper.toMessageDTO(message)).collect(Collectors.toList());
    }
}
