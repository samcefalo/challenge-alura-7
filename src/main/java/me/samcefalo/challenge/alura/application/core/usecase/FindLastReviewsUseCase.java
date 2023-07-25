package me.samcefalo.challenge.alura.application.core.usecase;

import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.ports.in.FindLastReviewsInputPort;
import me.samcefalo.challenge.alura.application.ports.out.FindLastReviewsOutputPort;

import java.util.List;

public class FindLastReviewsUseCase implements FindLastReviewsInputPort {

    private final FindLastReviewsOutputPort findLastReviewsOutputPort;

    public FindLastReviewsUseCase(FindLastReviewsOutputPort findLastReviewsOutputPort) {
        this.findLastReviewsOutputPort = findLastReviewsOutputPort;
    }

    @Override
    public List<Review> findLastReview() {
        return findLastReviewsOutputPort.findLastReview();
    }

}
