package me.samcefalo.challenge.alura.adapters.out;

import me.samcefalo.challenge.alura.adapters.out.repository.ReviewRepository;
import me.samcefalo.challenge.alura.adapters.out.repository.entity.ReviewEntity;
import me.samcefalo.challenge.alura.adapters.out.repository.entity.ReviewEntityMother;
import me.samcefalo.challenge.alura.adapters.out.repository.mapper.ReviewEntityMapper;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.core.domain.ReviewMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FindLastReviewsAdapterTest {

    private ReviewRepository reviewRepository;
    private ReviewEntityMapper reviewEntityMapper;
    private FindLastReviewsAdapter findLastReviewsAdapter;

    @BeforeEach
    void setUp() {
        reviewRepository = mock(ReviewRepository.class);
        reviewEntityMapper = mock(ReviewEntityMapper.class);
        findLastReviewsAdapter = new FindLastReviewsAdapter(reviewRepository, reviewEntityMapper);
    }

    @Test
    public void should_find_last_review() {
        Review expected = ReviewMother.createReview("test", "test");
        List<ReviewEntity> reviewEntities = List.of(ReviewEntityMother.createReviewEntity("test", "test"),
                ReviewEntityMother.createReviewEntity("test2", "test2"),
                ReviewEntityMother.createReviewEntity("test3", "test3"));

        when(reviewRepository.findTop3ByOrderByDateDesc()).thenReturn(reviewEntities);
        when(reviewEntityMapper.toReview(any(ReviewEntity.class))).thenReturn(expected);

        List<Review> result = findLastReviewsAdapter.findLastReview();

        assertEquals(3, result.size());
        assertEquals(expected, result.get(0));
        assertEquals(expected, result.get(1));
        assertEquals(expected, result.get(2));
        verify(reviewRepository, times(1)).findTop3ByOrderByDateDesc();
        verify(reviewEntityMapper, times(3)).toReview(any(ReviewEntity.class));
    }
}