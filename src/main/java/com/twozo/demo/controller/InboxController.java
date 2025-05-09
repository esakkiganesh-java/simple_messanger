package com.twozo.demo.controller;

import com.twozo.demo.model.Dto.MessageDto;
import com.twozo.demo.model.Dto.MessageResponseDto;
import com.twozo.demo.service.InboxServices;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.Collection;



@RestController
@RequestMapping("/inbox")
public class InboxController {

    private final InboxServices inboxService;


    public InboxController(InboxServices inboxService) {
        this.inboxService = inboxService;
    }


    @PostMapping("/getInboxMessages")
    public Collection<MessageResponseDto> getInboxMessages(@RequestParam int id){
        Collection<MessageResponseDto> inboxMessages = inboxService.getInboxHistory(id);

        Collection<MessageResponseDto> responseList = new ArrayList<>();
        for (MessageResponseDto msg : inboxMessages) {
            responseList.add(new MessageResponseDto(
                    msg.getMessageId(),
                    msg.getReceiverName(),
                    msg.getMessageContent(),
                    msg.getSenderName(),
                    msg.getSentTimeStamp()
            ));
        }

        return responseList;
    }

    @PostMapping("/getChatHistory")
    public Collection<MessageResponseDto> getChatHistory(@RequestBody MessageDto messageDto) {
        Collection<MessageResponseDto> chatHistory = inboxService.getChatHistory(messageDto);

        Collection<MessageResponseDto> responseList = new ArrayList<>();
        for (MessageResponseDto msg : chatHistory) {
            responseList.add(new MessageResponseDto(
                    msg.getMessageId(),
                    msg.getReceiverName(),
                    msg.getMessageContent(),
                    msg.getSenderName(),
                    msg.getSentTimeStamp()
            ));
        }

        return responseList;
    }
}

