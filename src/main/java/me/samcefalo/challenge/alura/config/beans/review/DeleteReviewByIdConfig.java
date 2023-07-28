package me.samcefalo.challenge.alura.config.beans.review;

import me.samcefalo.challenge.alura.application.core.usecase.review.DeleteReviewByIdUseCase;
import me.samcefalo.challenge.alura.application.ports.in.review.FindReviewByIdInputPort;
import me.samcefalo.challenge.alura.application.ports.out.review.DeleteReviewByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteReviewByIdConfig {

    @Bean
    public DeleteReviewByIdUseCase deleteReviewByIdUseCase(FindReviewByIdInputPort findReviewByIdInputPort, DeleteReviewByIdOutputPort deleteReviewByIdOutputPort) {
        return new DeleteReviewByIdUseCase(findReviewByIdInputPort, deleteReviewByIdOutputPort);
    }

}
