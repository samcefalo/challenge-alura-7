package me.samcefalo.challenge.alura.application.core.usecase;

import me.samcefalo.challenge.alura.application.core.domain.Author;
import me.samcefalo.challenge.alura.application.core.domain.AuthorMother;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.core.domain.ReviewMother;
import me.samcefalo.challenge.alura.application.ports.out.FindAuthorByIdOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.InsertReviewOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class InsertReviewUseCaseTest {
    private InsertReviewOutputPort insertReviewOutputPort;
    private FindAuthorByIdOutputPort findAuthorByIdOutputPort;
    private InsertReviewUseCase insertReviewUseCase;

    @BeforeEach
    void setUp() {
        insertReviewOutputPort = mock(InsertReviewOutputPort.class);
        findAuthorByIdOutputPort = mock(FindAuthorByIdOutputPort.class);
        insertReviewUseCase = new InsertReviewUseCase(insertReviewOutputPort, findAuthorByIdOutputPort);
    }

    @Test
    public void should_insert() {
        String authorId = "test";
        Review review = ReviewMother.createReview("test", "test");
        Author expectedAuthor = AuthorMother.createAuthor("test");

        when(findAuthorByIdOutputPort.findById(authorId)).thenReturn(expectedAuthor);
        doNothing().when(insertReviewOutputPort).insert(review);

        insertReviewUseCase.insert(review, authorId);

        assertEquals(expectedAuthor, review.getAuthor());
        assertNotNull(review.getDate());
        verify(findAuthorByIdOutputPort, times(1)).findById(authorId);
        verify(insertReviewOutputPort, times(1)).insert(review);
    }

}