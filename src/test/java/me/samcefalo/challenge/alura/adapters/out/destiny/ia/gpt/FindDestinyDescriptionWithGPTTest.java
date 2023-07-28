package me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt;

import feign.FeignException;
import me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.ChatGPTPromptClient;
import me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.request.GPTPromptRequest;
import me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.response.GPTPromptResponse;
import me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.response.GPTPromptResponseMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindDestinyDescriptionWithGPTTest {

    private ChatGPTPromptClient chatGPTPromptClient;
    private FindDestinyDescriptionWithGPT findDestinyDescriptionWithGPT;
    private String apikey;

    @BeforeEach
    void setUp() {
        String model = "model";
        apikey = "apikey";
        chatGPTPromptClient = mock(ChatGPTPromptClient.class);
        findDestinyDescriptionWithGPT = new FindDestinyDescriptionWithGPT(chatGPTPromptClient, model, apikey);
    }

    @Test
    public void should_return_description() {
        GPTPromptResponse expected = GPTPromptResponseMother.create();

        when(chatGPTPromptClient.prompt(any(GPTPromptRequest.class), eq("Bearer " + apikey))).thenReturn(expected);

        String description = findDestinyDescriptionWithGPT.findDescription("name");

        assertNotNull(description);
        assertEquals(expected.getChoices().get(0).getMessage().getContent(), description);
    }

    @Test
    public void should_not_return_description() {
        when(chatGPTPromptClient.prompt(any(GPTPromptRequest.class), eq("Bearer " + apikey))).thenThrow(FeignException.class);

        String description = findDestinyDescriptionWithGPT.findDescription("name");

        assertNull(description);
    }
}