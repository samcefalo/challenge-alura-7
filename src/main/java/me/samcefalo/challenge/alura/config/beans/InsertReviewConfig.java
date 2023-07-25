package me.samcefalo.challenge.alura.config.beans;

import me.samcefalo.challenge.alura.application.core.usecase.InsertReviewUseCase;
import me.samcefalo.challenge.alura.application.ports.out.FindAuthorByIdOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.InsertReviewOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertReviewConfig {

    @Bean
    public InsertReviewUseCase insertReviewUseCase(InsertReviewOutputPort insertReviewOutputPort, FindAuthorByIdOutputPort findAuthorByIdOutputPort) {
        return new InsertReviewUseCase(insertReviewOutputPort, findAuthorByIdOutputPort);
    }
    
}
