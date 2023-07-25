package me.samcefalo.challenge.alura.application.core.usecase;

import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.ports.in.FindReviewByIdInputPort;
import me.samcefalo.challenge.alura.application.ports.out.FindReviewByIdOutputPort;

public class FindReviewByIdUseCase implements FindReviewByIdInputPort {

    private final FindReviewByIdOutputPort findReviewByIdOutputPort;

    public FindReviewByIdUseCase(FindReviewByIdOutputPort findReviewByIdOutputPort) {
        this.findReviewByIdOutputPort = findReviewByIdOutputPort;
    }

    @Override
    public Review findById(String id) {
        return findReviewByIdOutputPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

}
