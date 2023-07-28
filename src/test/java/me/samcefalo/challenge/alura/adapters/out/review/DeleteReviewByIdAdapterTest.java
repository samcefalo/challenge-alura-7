package me.samcefalo.challenge.alura.adapters.out.review;

import me.samcefalo.challenge.alura.adapters.out.review.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class DeleteReviewByIdAdapterTest {
    private ReviewRepository reviewRepository;
    private DeleteReviewByIdAdapter deleteReviewByIdAdapter;

    @BeforeEach
    void setUp() {
        reviewRepository = mock(ReviewRepository.class);
        deleteReviewByIdAdapter = new DeleteReviewByIdAdapter(reviewRepository);
    }

    @Test
    public void should_delete_by_id() {
        String id = "id";

        doNothing().when(reviewRepository).deleteById(id);

        deleteReviewByIdAdapter.deleteById(id);

        verify(reviewRepository, times(1)).deleteById(id);
    }
}