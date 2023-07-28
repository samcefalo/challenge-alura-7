package me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.request;


import lombok.Data;
import me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.common.GPTMessage;

import java.util.ArrayList;
import java.util.List;

@Data
public class GPTPromptRequest {

    private String model;
    private final List<GPTMessage> messages = new ArrayList<>();
    private int maxTokens = 150;

    public void addMessage(String content) {
        messages.add(new GPTMessage("system", content));
    }

}
