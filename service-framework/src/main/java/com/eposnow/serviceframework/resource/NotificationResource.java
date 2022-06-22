package com.eposnow.serviceframework.resource;

import com.eposnow.serviceframework.dto.Message;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/message")
@Tag(name = "apis")
public class NotificationResource {

    private static final Logger logger = LoggerFactory.getLogger(NotificationResource.class);

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable("id") Long id){
        logger.info(String.format("%s","/message/", id));
        return ResponseEntity.ok().body(createMessage(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Message>>getAllMessages(){
        return getMessages();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Message>> getMessages(){
        logger.info(String.format("%s","/messages/"));
        List<Message> messages = new ArrayList();
        messages.add(createMessage(2343L));
        messages.add(createMessage(23343L));
        messages.add(createMessage(2334343L));
        messages.add(createMessage(23343L));
        messages.add(createMessage(1343L));
        messages.add(createMessage(55343L));
        return ResponseEntity.ok().body(messages);
    }

    private Message createMessage(Long id){
        Message message = new Message();
        message.setCreatedAt(new Date());
        message.setId(id);
        message.setCreatedBy("static");
        message.setMessage("You have got a message");
        return message;
    }
}
