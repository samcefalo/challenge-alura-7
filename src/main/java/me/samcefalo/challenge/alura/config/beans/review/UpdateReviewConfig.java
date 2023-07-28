package me.samcefalo.challenge.alura.config.beans.review;

import me.samcefalo.challenge.alura.application.core.usecase.review.UpdateReviewUseCase;
import me.samcefalo.challenge.alura.application.ports.out.author.FindAuthorByIdOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.review.UpdateReviewOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateReviewConfig {

    @Bean
    public UpdateReviewUseCase updateReviewUseCase(UpdateReviewOutputPort updateReviewOutputPort, FindAuthorByIdOutputPort findAuthorByIdOutputPort) {
        return new UpdateReviewUseCase(updateReviewOutputPort, findAuthorByIdOutputPort);
    }

}
