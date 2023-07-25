package me.samcefalo.challenge.alura.config.beans;

import me.samcefalo.challenge.alura.application.core.usecase.UpdateReviewUseCase;
import me.samcefalo.challenge.alura.application.ports.out.FindAuthorByIdOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.UpdateReviewOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateReviewConfig {

    @Bean
    public UpdateReviewUseCase updateReviewUseCase(UpdateReviewOutputPort updateReviewOutputPort, FindAuthorByIdOutputPort findAuthorByIdOutputPort) {
        return new UpdateReviewUseCase(updateReviewOutputPort, findAuthorByIdOutputPort);
    }

}
