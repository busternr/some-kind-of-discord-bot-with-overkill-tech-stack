package com.nikolayromanov.backend.controllers;

import com.nikolayromanov.backend.entities.User;
import com.nikolayromanov.backend.handlers.AuthHandler;
import com.nikolayromanov.backend.handlers.MessageHandler;
import com.nikolayromanov.backend.models.messages.Null;
import com.nikolayromanov.backend.models.Message;
import com.nikolayromanov.backend.models.MessageObject;
import com.nikolayromanov.backend.models.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class AuthController {
    @Autowired
    MessageHandler messageHandler;
    @Autowired
    AuthHandler authHandler;

    @MessageMapping("queue/user/auth")
    @SendTo("/queue/user")
    public MessageObject<ResponseBody> authRegister(MessageObject<User> messageObject) {
        Message<User, Null> message = new Message<>(messageObject, new MessageObject<>());

        return messageHandler.handleMessage(message);
    }
}