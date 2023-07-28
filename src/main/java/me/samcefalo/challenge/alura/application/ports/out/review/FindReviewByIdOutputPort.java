package me.samcefalo.challenge.alura.application.ports.out.review;

import me.samcefalo.challenge.alura.application.core.domain.Review;

import java.util.Optional;

public interface FindReviewByIdOutputPort {

    Optional<Review> findById(String id);

}
