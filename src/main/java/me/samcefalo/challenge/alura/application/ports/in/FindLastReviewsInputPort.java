package me.samcefalo.challenge.alura.application.ports.in;

import me.samcefalo.challenge.alura.application.core.domain.Review;

import java.util.List;

public interface FindLastReviewsInputPort {

    List<Review> findLastReview();
    
}
