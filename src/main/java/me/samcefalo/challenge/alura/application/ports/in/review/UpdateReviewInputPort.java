package me.samcefalo.challenge.alura.application.ports.in.review;

import me.samcefalo.challenge.alura.application.core.domain.Review;

public interface UpdateReviewInputPort {

    void update(Review review, String authorId);

}
