package me.samcefalo.challenge.alura.application.ports.out;

import me.samcefalo.challenge.alura.application.core.domain.Review;

import java.util.List;

public interface FindLastReviewsOutputPort {

    List<Review> findLastReview();
    
}
