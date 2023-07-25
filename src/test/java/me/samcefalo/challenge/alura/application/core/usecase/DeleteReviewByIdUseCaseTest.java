package me.samcefalo.challenge.alura.application.core.usecase;

import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.core.domain.ReviewMother;
import me.samcefalo.challenge.alura.application.ports.in.FindReviewByIdInputPort;
import me.samcefalo.challenge.alura.application.ports.out.DeleteReviewByIdOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class DeleteReviewByIdUseCaseTest {
    private FindReviewByIdInputPort findReviewByIdInputPort;
    private DeleteReviewByIdOutputPort deleteReviewByIdOutputPort;
    private DeleteReviewByIdUseCase deleteReviewByIdUseCase;

    @BeforeEach
    void setUp() {
        findReviewByIdInputPort = mock(FindReviewByIdInputPort.class);
        deleteReviewByIdOutputPort = mock(DeleteReviewByIdOutputPort.class);
        deleteReviewByIdUseCase = new DeleteReviewByIdUseCase(findReviewByIdInputPort, deleteReviewByIdOutputPort);
    }

    @Test
    public void should_delete_review_by_id() {
        Review expected = ReviewMother.createReview("test", "test");

        when(findReviewByIdInputPort.findById(expected.getId())).thenReturn(expected);
        doNothing().when(deleteReviewByIdOutputPort).deleteById(expected.getId());

        deleteReviewByIdUseCase.deleteById(expected.getId());

        verify(findReviewByIdInputPort, times(1)).findById(expected.getId());
        verify(deleteReviewByIdOutputPort, times(1)).deleteById(expected.getId());
    }
}