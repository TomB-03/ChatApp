package com.tomB.chatApp.Controller;

import com.tomB.chatApp.Controller.Model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receiveBroadcastMessage(@Payload Message message) {
        return message;
    }

    @MessageMapping("/private-message")
    public Message receivePrivateMessage(@Payload Message message) {

        template.convertAndSendToUser(message.getReceiver(),"/private", message); //to get message: /user/username/private
        return message;
    }


}
