package com.yidoughi.rest;

import com.yidoughi.config.Application;
import com.yidoughi.domain.Message;
import com.yidoughi.service.KafkaSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class GenericRestController {
    private final Logger log = LoggerFactory.getLogger(GenericRestController.class);

    @Autowired
    public KafkaSenderService kafkaSenderService;

    @GetMapping(value= "/version")
    public ResponseEntity<Application> version () {
        return new ResponseEntity<>(new Application(), HttpStatus.OK);
    }
    @PostMapping(value= "/produce")
    public ResponseEntity<?> producer (@RequestBody Message message) {
        kafkaSenderService.sendMessage(message);
        return  new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(value= "/meteo")
    public ResponseEntity<?> meteo () {
        try {
            HttpEntity request = new RestTemplate().getForEntity("https://public.opendatasoft.com/api/records/1.0/search/?dataset=arome-0025-sp1_sp2", Map.class);
            kafkaSenderService.sendMessage((Map<String, ?>) request.getBody());
            return new ResponseEntity<>(request.getBody(), HttpStatus.OK);

        } catch (HttpClientErrorException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
