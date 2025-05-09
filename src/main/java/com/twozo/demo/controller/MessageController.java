package com.twozo.demo.controller;


import com.twozo.demo.model.Dto.MessageDto;
import com.twozo.demo.model.Message;
import com.twozo.demo.model.Dto.ResponseDto;
import com.twozo.demo.service.MessageServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Instant;

@RestController
@RequestMapping("/api/messages")
public class MessageController{

    private final MessageServices messageService;



    public MessageController(MessageServices messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public ResponseEntity<ResponseDto> sendMessage(@RequestBody Message message) {
        message.setSentTimestamp((Instant.now()));
        boolean result = messageService.sendMessage(message);
        if(result){
            return ResponseEntity.ok(new ResponseDto("Message sent successfully"));
        }
        return ResponseEntity.badRequest()
                .body(new ResponseDto("sender or receiver details not found/Message not sent"));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ResponseDto> editMessage(@PathVariable int id, @RequestParam String content) {
        MessageDto messageDto = new MessageDto();
        messageDto.setMessageId(id);
        messageDto.setContent(content);

        boolean result = messageService.editMessage(messageDto);
        if(result){
            return ResponseEntity.ok(new ResponseDto("Message edited successfully"));
        }
        return ResponseEntity.badRequest()
                .body(new ResponseDto("Message details not found/Message not edited"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteMessage(@PathVariable int id) {
        boolean result = messageService.deleteMessage(id);
        if(result){
            return ResponseEntity.ok(new ResponseDto("Message deleted successfully"));
        }
        return ResponseEntity.badRequest()
                .body(new ResponseDto("Message Details not found/Message not deleted"));
    }

}

