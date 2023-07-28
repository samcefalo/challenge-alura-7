package me.samcefalo.challenge.alura.adapters.out.review;

import me.samcefalo.challenge.alura.adapters.out.review.repository.ReviewRepository;
import me.samcefalo.challenge.alura.adapters.out.review.repository.entity.ReviewEntity;
import me.samcefalo.challenge.alura.adapters.out.review.repository.entity.ReviewEntityMother;
import me.samcefalo.challenge.alura.adapters.out.review.repository.mapper.ReviewEntityMapper;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.core.domain.ReviewMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

class FindReviewByIdAdapterTest {

    private ReviewRepository reviewRepository;
    private ReviewEntityMapper reviewEntityMapper;
    private FindReviewByIdAdapter findReviewByIdAdapter;

    @BeforeEach
    void setUp() {
        reviewRepository = mock(ReviewRepository.class);
        reviewEntityMapper = mock(ReviewEntityMapper.class);
        findReviewByIdAdapter = new FindReviewByIdAdapter(reviewRepository, reviewEntityMapper);
    }

    @Test
    public void should_return_review_by_id() {
        String id = "1";
        Optional<Review> expected = Optional.of(ReviewMother.createReview("test", "test"));
        Optional<ReviewEntity> expectedEntity = Optional.of(ReviewEntityMother.createReviewEntity("test", "test"));

        when(reviewRepository.findById(id)).thenReturn(expectedEntity);
        when(reviewEntityMapper.toReview(expectedEntity.get())).thenReturn(expected.get());

        Optional<Review> result = findReviewByIdAdapter.findById(id);

        assertFalse(result.isEmpty());
        assertEquals(expected, result);
        verify(reviewRepository, times(1)).findById(id);
        verify(reviewEntityMapper, times(1)).toReview(expectedEntity.get());
    }
}