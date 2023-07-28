package me.samcefalo.challenge.alura.config.beans.review;

import me.samcefalo.challenge.alura.application.core.usecase.review.FindLastReviewsUseCase;
import me.samcefalo.challenge.alura.application.ports.out.review.FindLastReviewsOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindLastReviewsConfig {

    @Bean
    public FindLastReviewsUseCase findLastReviewsUseCase(FindLastReviewsOutputPort findLastReviewsOutputPort) {
        return new FindLastReviewsUseCase(findLastReviewsOutputPort);
    }
    
}
