package me.samcefalo.challenge.alura.application.core.usecase;

import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.core.domain.ReviewMother;
import me.samcefalo.challenge.alura.application.ports.out.FindLastReviewsOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FindLastReviewsUseCaseTest {

    private FindLastReviewsOutputPort findLastReviewsOutputPort;
    private FindLastReviewsUseCase findLastReviewsUseCase;

    @BeforeEach
    void setUp() {
        findLastReviewsOutputPort = mock(FindLastReviewsOutputPort.class);
        findLastReviewsUseCase = new FindLastReviewsUseCase(findLastReviewsOutputPort);
    }

    @Test
    public void should_find_last_reviews() {
        List<Review> expectedReviews = List.of(
                ReviewMother.createReview("test", "test"),
                ReviewMother.createReview("test2", "test2"),
                ReviewMother.createReview("test3", "test3")
        );

        when(findLastReviewsOutputPort.findLastReview()).thenReturn(expectedReviews);

        List<Review> result = findLastReviewsUseCase.findLastReview();

        assertEquals(expectedReviews, result);
        verify(findLastReviewsOutputPort, times(1)).findLastReview();
    }

}