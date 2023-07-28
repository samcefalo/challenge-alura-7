package me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import me.samcefalo.challenge.alura.adapters.out.destiny.ia.FindDestinyDescriptionWithIA;
import me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.ChatGPTPromptClient;
import me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.request.GPTPromptRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FindDestinyDescriptionWithGPT implements FindDestinyDescriptionWithIA {

    private final ChatGPTPromptClient chatGPTPromptClient;
    private final String model;
    private final String apiKey;

    @Autowired
    public FindDestinyDescriptionWithGPT(ChatGPTPromptClient chatGPTPromptClient, @Value("${chat.gpt.model}") String model, @Value("${chat.gpt.api.key}") String apiKey) {
        this.chatGPTPromptClient = chatGPTPromptClient;
        this.model = model;
        this.apiKey = apiKey;
    }

    @Override
    public String findDescription(String destinyName) {
        GPTPromptRequest gptPromptRequest = new GPTPromptRequest();
        gptPromptRequest.setModel(model);
        String PROMPT = "Faça um resumo sobre %s enfatizando o porque este lugar é incrível. Utilize uma linguagem informal e até 100 caracteres no máximo em cada parágrafo. Crie 2 parágrafos neste resumo.";
        gptPromptRequest.addMessage(String.format(PROMPT, destinyName));
        gptPromptRequest.setMaxTokens(100);

        try {
            return chatGPTPromptClient.prompt(gptPromptRequest, "Bearer " + apiKey).getChoices().get(0).getMessage().getContent();
        } catch (FeignException e) {
            log.warn("Error on findDescription with GPT: " + e.getMessage());
            return null;
        }
    }
}
