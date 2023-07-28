package me.samcefalo.challenge.alura.config.beans.review;

import me.samcefalo.challenge.alura.application.core.usecase.review.InsertReviewUseCase;
import me.samcefalo.challenge.alura.application.ports.out.author.FindAuthorByIdOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.review.InsertReviewOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertReviewConfig {

    @Bean
    public InsertReviewUseCase insertReviewUseCase(InsertReviewOutputPort insertReviewOutputPort, FindAuthorByIdOutputPort findAuthorByIdOutputPort) {
        return new InsertReviewUseCase(insertReviewOutputPort, findAuthorByIdOutputPort);
    }
    
}
