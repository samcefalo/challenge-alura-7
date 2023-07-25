package me.samcefalo.challenge.alura.application.core.usecase;

import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.core.domain.ReviewMother;
import me.samcefalo.challenge.alura.application.ports.out.FindReviewByIdOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FindReviewByIdUseCaseTest {
    private FindReviewByIdOutputPort findReviewByIdOutputPort;
    private FindReviewByIdUseCase findReviewByIdUseCase;

    @BeforeEach
    void setup() {
        findReviewByIdOutputPort = mock(FindReviewByIdOutputPort.class);
        findReviewByIdUseCase = new FindReviewByIdUseCase(findReviewByIdOutputPort);
    }

    @Test
    public void should_find_review_by_id() {
        String id = "1";
        Review expected = ReviewMother.createReview("test", "test");

        when(findReviewByIdOutputPort.findById(id)).thenReturn(Optional.of(expected));

        Optional<Review> result = findReviewByIdOutputPort.findById(id);

        assertFalse(result.isEmpty());
        assertEquals(expected, result.get());
        verify(findReviewByIdOutputPort, times(1)).findById(id);
    }

    @Test
    public void should_not_find() {
        String id = "1";

        when(findReviewByIdOutputPort.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> findReviewByIdUseCase.findById(id));

        verify(findReviewByIdOutputPort, times(1)).findById(id);
    }
}