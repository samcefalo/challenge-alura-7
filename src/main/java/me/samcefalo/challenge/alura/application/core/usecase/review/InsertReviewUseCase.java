package me.samcefalo.challenge.alura.application.core.usecase.review;

import me.samcefalo.challenge.alura.application.core.domain.Author;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.ports.in.review.InsertReviewInputPort;
import me.samcefalo.challenge.alura.application.ports.out.author.FindAuthorByIdOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.review.InsertReviewOutputPort;

import static me.samcefalo.challenge.alura.util.DateUtil.now;

public class InsertReviewUseCase implements InsertReviewInputPort {

    private final InsertReviewOutputPort insertReviewOutputPort;
    private final FindAuthorByIdOutputPort findAuthorByIdOutputPort;

    public InsertReviewUseCase(InsertReviewOutputPort insertReviewOutputPort, FindAuthorByIdOutputPort findAuthorByIdOutputPort) {
        this.insertReviewOutputPort = insertReviewOutputPort;
        this.findAuthorByIdOutputPort = findAuthorByIdOutputPort;
    }

    @Override
    public void insert(Review review, String authorId) {
        Author author = findAuthorByIdOutputPort.findById(authorId);
        review.setAuthor(author);
        review.setDate(now());

        insertReviewOutputPort.insert(review);
    }

}
