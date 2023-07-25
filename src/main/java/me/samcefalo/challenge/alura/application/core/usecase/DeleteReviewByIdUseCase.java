package me.samcefalo.challenge.alura.application.core.usecase;

import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.ports.in.DeleteReviewByIdInputPort;
import me.samcefalo.challenge.alura.application.ports.in.FindReviewByIdInputPort;
import me.samcefalo.challenge.alura.application.ports.out.DeleteReviewByIdOutputPort;

public class DeleteReviewByIdUseCase implements DeleteReviewByIdInputPort {

    private final FindReviewByIdInputPort findReviewByIdInputPort;
    private final DeleteReviewByIdOutputPort deleteReviewByIdOutputPort;

    public DeleteReviewByIdUseCase(FindReviewByIdInputPort findReviewByIdInputPort, DeleteReviewByIdOutputPort deleteReviewByIdOutputPort) {
        this.findReviewByIdInputPort = findReviewByIdInputPort;
        this.deleteReviewByIdOutputPort = deleteReviewByIdOutputPort;
    }

    @Override
    public void deleteById(String id) {
        Review review = findReviewByIdInputPort.findById(id);

        deleteReviewByIdOutputPort.deleteById(review.getId());
    }
}
