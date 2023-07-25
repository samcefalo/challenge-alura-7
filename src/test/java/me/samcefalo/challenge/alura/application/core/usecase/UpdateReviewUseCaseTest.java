package me.samcefalo.challenge.alura.application.core.usecase;

import me.samcefalo.challenge.alura.application.core.domain.Author;
import me.samcefalo.challenge.alura.application.core.domain.AuthorMother;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.core.domain.ReviewMother;
import me.samcefalo.challenge.alura.application.ports.out.FindAuthorByIdOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.UpdateReviewOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class UpdateReviewUseCaseTest {

    private UpdateReviewOutputPort updateReviewOutputPort;
    private FindAuthorByIdOutputPort findAuthorByIdOutputPort;
    private UpdateReviewUseCase updateReviewUseCase;

    @BeforeEach
    void setUp() {
        updateReviewOutputPort = mock(UpdateReviewOutputPort.class);
        findAuthorByIdOutputPort = mock(FindAuthorByIdOutputPort.class);
        updateReviewUseCase = new UpdateReviewUseCase(updateReviewOutputPort, findAuthorByIdOutputPort);
    }

    @Test
    public void should_update() {
        String authorId = "test";
        Review review = ReviewMother.createReview("test", "test");
        Author expectedAuthor = AuthorMother.createAuthor("test");

        when(findAuthorByIdOutputPort.findById(authorId)).thenReturn(expectedAuthor);
        doNothing().when(updateReviewOutputPort).update(review);

        updateReviewUseCase.update(review, authorId);

        verify(updateReviewOutputPort, times(1)).update(review);
        verify(findAuthorByIdOutputPort, times(1)).findById(authorId);
    }
}