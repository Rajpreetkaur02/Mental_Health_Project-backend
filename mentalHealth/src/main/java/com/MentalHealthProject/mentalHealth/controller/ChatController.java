package com.MentalHealthProject.mentalHealth.controller;

import com.MentalHealthProject.mentalHealth.entities.ChatMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChatController {

    private Map<String, List<WebSocketSession>> chatRooms = new ConcurrentHashMap<>();

    @MessageMapping("/chat/{GroupName}/sendMessage")
    @SendTo("/topic/{GroupName}")
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage, @DestinationVariable String GroupName
    ){
        List<WebSocketSession> sessions = chatRooms.getOrDefault(GroupName, new ArrayList<>());
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(new TextMessage(chatMessage.getContent()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return chatMessage;
    }

    @MessageMapping("/chat/{GroupName}/addUser")
    @SendTo("/topic/{GroupName}")
    public ChatMessage addUser(
        @Payload ChatMessage chatMessage,
        SimpMessageHeaderAccessor headerAccessor,
        @DestinationVariable String GroupName
    ){
        //add username in web socket session
        System.out.println(GroupName);
        WebSocketSession session = (WebSocketSession) headerAccessor.getSessionAttributes().get("session");
        if (session != null) {
            List<WebSocketSession> sessions = chatRooms.getOrDefault(GroupName, new ArrayList<>());
            sessions.add(session);
            chatRooms.put(GroupName, sessions);
            headerAccessor.getSessionAttributes().put("GroupName", GroupName);
        }
        return chatMessage;
    }
}
