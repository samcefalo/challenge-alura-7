package me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.common.GPTMessage;

import java.util.ArrayList;
import java.util.List;

@Data
public class GPTPromptResponse {

    private String id;
    private String model;
    private String object;
    private long created;
    private Usage usage;
    private final List<Choice> choices = new ArrayList<>();

    @Data
    @AllArgsConstructor
    public static class Choice {
        private int index;
        private String finish_reason;
        private GPTMessage message;
    }

    @Data
    @AllArgsConstructor
    public static class Usage {
        private int promptTokens;
        private int completionTokens;
        private int totalTokens;
    }

}
