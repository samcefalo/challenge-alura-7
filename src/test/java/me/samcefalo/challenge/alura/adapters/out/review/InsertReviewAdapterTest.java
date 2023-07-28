package me.samcefalo.challenge.alura.adapters.out.review;

import me.samcefalo.challenge.alura.adapters.out.review.repository.ReviewRepository;
import me.samcefalo.challenge.alura.adapters.out.review.repository.entity.ReviewEntity;
import me.samcefalo.challenge.alura.adapters.out.review.repository.entity.ReviewEntityMother;
import me.samcefalo.challenge.alura.adapters.out.review.repository.mapper.ReviewEntityMapper;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.core.domain.ReviewMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class InsertReviewAdapterTest {

    private ReviewRepository reviewRepository;
    private ReviewEntityMapper reviewEntityMapper;
    private InsertReviewAdapter insertReviewAdapter;

    @BeforeEach
    void setUp() {
        reviewRepository = mock(ReviewRepository.class);
        reviewEntityMapper = mock(ReviewEntityMapper.class);
        insertReviewAdapter = new InsertReviewAdapter(reviewRepository, reviewEntityMapper);
    }

    @Test
    public void should_insert() {
        Review review = ReviewMother.createReview("test", "test");
        ReviewEntity expectedEntity = ReviewEntityMother.createReviewEntity("test", "test");

        when(reviewEntityMapper.toReviewEntity(review)).thenReturn(expectedEntity);
        when(reviewRepository.save(expectedEntity)).thenReturn(expectedEntity);

        insertReviewAdapter.insert(review);

        verify(reviewRepository, times(1)).save(expectedEntity);
        verify(reviewEntityMapper, times(1)).toReviewEntity(review);
    }
}