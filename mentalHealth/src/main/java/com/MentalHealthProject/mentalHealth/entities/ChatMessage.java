package com.MentalHealthProject.mentalHealth.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

    private String content;
    private String sender;
    private MessageType type;

    public Object getSender() {
        return sender;
    }


}
