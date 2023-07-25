package me.samcefalo.challenge.alura.adapters.out;

import me.samcefalo.challenge.alura.adapters.out.repository.ReviewRepository;
import me.samcefalo.challenge.alura.adapters.out.repository.mapper.ReviewEntityMapper;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.ports.out.FindLastReviewsOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindLastReviewsAdapter implements FindLastReviewsOutputPort {

    private final ReviewRepository reviewRepository;
    private final ReviewEntityMapper reviewEntityMapper;

    @Autowired
    public FindLastReviewsAdapter(ReviewRepository reviewRepository, ReviewEntityMapper reviewEntityMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewEntityMapper = reviewEntityMapper;
    }

    @Override
    public List<Review> findLastReview() {
        return reviewRepository
                .findTop3ByOrderByDateDesc()
                .stream().map(reviewEntityMapper::toReview)
                .toList();
    }

}
