package me.samcefalo.challenge.alura.config.beans;

import me.samcefalo.challenge.alura.application.core.usecase.FindReviewByIdUseCase;
import me.samcefalo.challenge.alura.application.ports.out.FindReviewByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindReviewByIdConfig {

    @Bean
    public FindReviewByIdUseCase findReviewByIdUseCase(FindReviewByIdOutputPort findReviewByIdOutputPort) {
        return new FindReviewByIdUseCase(findReviewByIdOutputPort);
    }
    
}
