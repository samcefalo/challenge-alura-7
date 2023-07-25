package me.samcefalo.challenge.alura.adapters.out;

import me.samcefalo.challenge.alura.adapters.out.repository.ReviewRepository;
import me.samcefalo.challenge.alura.adapters.out.repository.entity.ReviewEntity;
import me.samcefalo.challenge.alura.adapters.out.repository.mapper.ReviewEntityMapper;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.ports.out.UpdateReviewOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateReviewAdapter implements UpdateReviewOutputPort {

    private final ReviewRepository reviewRepository;
    private final ReviewEntityMapper reviewEntityMapper;

    @Autowired
    public UpdateReviewAdapter(ReviewRepository reviewRepository, ReviewEntityMapper reviewEntityMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewEntityMapper = reviewEntityMapper;
    }

    @Override
    public void update(Review review) {
        ReviewEntity reviewEntity = reviewEntityMapper.toReviewEntity(review);

        reviewRepository.save(reviewEntity);
    }
}
