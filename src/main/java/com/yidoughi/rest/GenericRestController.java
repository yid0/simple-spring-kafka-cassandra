package com.yidoughi.rest;

import com.yidoughi.config.ApplicationInfo;
import com.yidoughi.domain.Message;
import com.yidoughi.dto.MessageDTO;
import com.yidoughi.service.KafkaSenderService;
import com.yidoughi.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author yidoughi
 */
@RestController
public class GenericRestController {
    private final Logger log = LoggerFactory.getLogger(GenericRestController.class);

    @Autowired
    private  ApplicationInfo applicationInfo;
    private  KafkaSenderService kafkaSenderService;
    private MessageService messageService;

    GenericRestController(KafkaSenderService kafkaSenderService, MessageService messageService) {
        this.kafkaSenderService =kafkaSenderService;
        this.messageService = messageService;
    }

    @GetMapping(value= "/version")
    public ResponseEntity<?> version () {
        return new ResponseEntity<>(applicationInfo, HttpStatus.OK);
    }

    @PostMapping(value= "/produce")
    public ResponseEntity<?> producer (@RequestBody MessageDTO message) {
        kafkaSenderService.sendMessage(message);
        return  new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping(value= "/message/{id}")
    public Message getMessage (@PathVariable String id) {
        return  messageService.retreiveMessage(id);
    }

    @GetMapping(value= "/message")
    public List<MessageDTO> getMessages () {
        return  messageService.getAllMessages();
    }


}
