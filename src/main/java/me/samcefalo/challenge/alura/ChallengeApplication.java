package me.samcefalo.challenge.alura;

import me.samcefalo.challenge.alura.adapters.out.client.FindAuthorByIdClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"me.samcefalo.challenge.alura.adapters.out.repository"})
@EnableFeignClients(clients = {FindAuthorByIdClient.class})
public class ChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }

}
