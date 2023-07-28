package me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client;

import feign.Headers;
import me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.request.GPTPromptRequest;
import me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.response.GPTPromptResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient( name = "ChatGPTPromptClient", url = "${chat.gpt.api.url}")
public interface ChatGPTPromptClient {

    @PostMapping()
    @Headers({"Content-Type: application/json"})
    GPTPromptResponse prompt(@RequestBody GPTPromptRequest gptPromptRequest, @RequestHeader("Authorization") String authorization);

}
