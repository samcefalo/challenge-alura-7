package me.samcefalo.challenge.alura.application.ports.out.review;

import me.samcefalo.challenge.alura.application.core.domain.Review;

public interface InsertReviewOutputPort {

    void insert(Review review);

}
