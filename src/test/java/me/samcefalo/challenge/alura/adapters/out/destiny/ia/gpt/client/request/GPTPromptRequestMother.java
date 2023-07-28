package me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.request;

public class GPTPromptRequestMother {

    public static GPTPromptRequest create() {
        GPTPromptRequest gptPromptRequest = new GPTPromptRequest();
        gptPromptRequest.setModel("model");
        gptPromptRequest.addMessage("message");
        gptPromptRequest.setMaxTokens(100);
        return gptPromptRequest;
    }

}