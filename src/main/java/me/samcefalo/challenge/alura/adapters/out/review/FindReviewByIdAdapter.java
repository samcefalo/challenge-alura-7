package me.samcefalo.challenge.alura.adapters.out.review;

import me.samcefalo.challenge.alura.adapters.out.review.repository.ReviewRepository;
import me.samcefalo.challenge.alura.adapters.out.review.repository.mapper.ReviewEntityMapper;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.ports.out.review.FindReviewByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindReviewByIdAdapter implements FindReviewByIdOutputPort {

    private final ReviewRepository reviewRepository;
    private final ReviewEntityMapper reviewEntityMapper;

    @Autowired
    public FindReviewByIdAdapter(ReviewRepository reviewRepository, ReviewEntityMapper reviewEntityMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewEntityMapper = reviewEntityMapper;
    }

    @Override
    public Optional<Review> findById(String id) {
        return reviewRepository.findById(id).map(reviewEntityMapper::toReview);
    }
}
