package me.samcefalo.challenge.alura.adapters.out.review;

import me.samcefalo.challenge.alura.adapters.out.review.repository.ReviewRepository;
import me.samcefalo.challenge.alura.application.ports.out.review.DeleteReviewByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteReviewByIdAdapter implements DeleteReviewByIdOutputPort {

    private final ReviewRepository reviewRepository;

    @Autowired
    public DeleteReviewByIdAdapter(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void deleteById(String id) {
        reviewRepository.deleteById(id);
    }

}
