package me.samcefalo.challenge.alura.application.core.usecase;

import me.samcefalo.challenge.alura.application.core.domain.Author;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.ports.in.UpdateReviewInputPort;
import me.samcefalo.challenge.alura.application.ports.out.FindAuthorByIdOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.UpdateReviewOutputPort;

import static me.samcefalo.challenge.alura.util.DateUtil.now;

public class UpdateReviewUseCase implements UpdateReviewInputPort {

    private final UpdateReviewOutputPort updateReviewOutputPort;
    private final FindAuthorByIdOutputPort findAuthorByIdOutputPort;

    public UpdateReviewUseCase(UpdateReviewOutputPort updateReviewOutputPort, FindAuthorByIdOutputPort findAuthorByIdOutputPort) {
        this.updateReviewOutputPort = updateReviewOutputPort;
        this.findAuthorByIdOutputPort = findAuthorByIdOutputPort;
    }

    @Override
    public void update(Review review, String authorId) {
        Author author = findAuthorByIdOutputPort.findById(authorId);
        review.setAuthor(author);
        review.setDate(now());

        updateReviewOutputPort.update(review);
    }
}
