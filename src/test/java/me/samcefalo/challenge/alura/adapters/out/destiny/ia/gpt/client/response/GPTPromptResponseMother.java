package me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.response;

import me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.common.GPTMessage;

public class GPTPromptResponseMother {

    public static GPTPromptResponse create() {
        GPTPromptResponse gptPromptResponse = new GPTPromptResponse();
        gptPromptResponse.setId("id");
        gptPromptResponse.setModel("model");
        gptPromptResponse.setObject("object");
        gptPromptResponse.setCreated(0);
        gptPromptResponse.setUsage(new GPTPromptResponse.Usage(0, 0, 0));
        gptPromptResponse.getChoices().add(new GPTPromptResponse.Choice(0, "finish_reason", new GPTMessage("system", "content")));
        return gptPromptResponse;
    }
}