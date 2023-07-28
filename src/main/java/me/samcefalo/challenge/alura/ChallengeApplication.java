package me.samcefalo.challenge.alura;

import me.samcefalo.challenge.alura.adapters.out.author.client.FindAuthorByIdClient;
import me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.ChatGPTPromptClient;
import me.samcefalo.challenge.alura.adapters.out.rating.client.FindDestinyRatingClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"me.samcefalo.challenge.alura.adapters.out.review.repository", "me.samcefalo.challenge.alura.adapters.out.destiny.repository"})
@EnableFeignClients(clients = {FindAuthorByIdClient.class, FindDestinyRatingClient.class, ChatGPTPromptClient.class})
public class ChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }

}
