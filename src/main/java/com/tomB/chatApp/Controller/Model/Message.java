package com.tomB.chatApp.Controller.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {

    private String sender;
    private String receiver;

    private String message;
    private String date;
    private Status status;

}
