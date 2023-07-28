package me.samcefalo.challenge.alura.adapters.in.review.controller;

import me.samcefalo.challenge.alura.adapters.in.review.controller.mapper.ReviewMapper;
import me.samcefalo.challenge.alura.adapters.in.review.controller.request.ReviewRequest;
import me.samcefalo.challenge.alura.adapters.in.review.controller.request.ReviewRequestMother;
import me.samcefalo.challenge.alura.adapters.in.review.controller.response.ReviewResponse;
import me.samcefalo.challenge.alura.adapters.in.review.controller.response.ReviewResponseMother;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.core.domain.ReviewMother;
import me.samcefalo.challenge.alura.application.ports.in.review.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReviewControllerTest {

    private ReviewMapper reviewMapper;
    private FindReviewByIdInputPort findReviewByIdInputPort;
    private FindLastReviewsInputPort findLastReviewsInputPort;
    private InsertReviewInputPort insertReviewInputPort;
    private UpdateReviewInputPort updateReviewInputPort;
    private DeleteReviewByIdInputPort deleteReviewByIdInputPort;

    private ReviewController reviewController;

    @BeforeEach
    void setUp() {
        reviewMapper = mock(ReviewMapper.class);
        findReviewByIdInputPort = mock(FindReviewByIdInputPort.class);
        findLastReviewsInputPort = mock(FindLastReviewsInputPort.class);
        insertReviewInputPort = mock(InsertReviewInputPort.class);
        updateReviewInputPort = mock(UpdateReviewInputPort.class);
        deleteReviewByIdInputPort = mock(DeleteReviewByIdInputPort.class);
        reviewController = new ReviewController(reviewMapper, findReviewByIdInputPort, findLastReviewsInputPort, insertReviewInputPort, updateReviewInputPort, deleteReviewByIdInputPort);
    }

    @Test
    public void should_find_by_id() {
        String id = "1";
        Review expected = ReviewMother.createReview("test", "test");
        ReviewResponse expectecdResponse = ReviewResponseMother.create();

        when(reviewMapper.toResponse(expected)).thenReturn(expectecdResponse);
        when(findReviewByIdInputPort.findById(id)).thenReturn(expected);

        ResponseEntity<ReviewResponse> response = reviewController.findById(id);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        assertEquals(expectecdResponse, response.getBody());

        verify(findReviewByIdInputPort, times(1)).findById(id);
        verify(reviewMapper, times(1)).toResponse(expected);
    }

    @Test
    public void should_find_last() {
        Pageable pageable = PageRequest.of(0, 10);

        List<Review> expected = Stream.of(ReviewMother.createReview("test", "test"),
                ReviewMother.createReview("test2", "test2"),
                ReviewMother.createReview("test3", "test3")).toList();
        ReviewResponse expectecdResponse = ReviewResponseMother.create();

        when(reviewMapper.toResponse(any(Review.class))).thenReturn(expectecdResponse);
        when(findLastReviewsInputPort.findLastReview()).thenReturn(expected);

        ResponseEntity<Page<ReviewResponse>> response = reviewController.findLast(pageable);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        assertEquals(expected.size(), Objects.requireNonNull(response.getBody()).getTotalElements());

        verify(findLastReviewsInputPort, times(1)).findLastReview();
        verify(reviewMapper, times(expected.size())).toResponse(any(Review.class));
    }

    @Test
    public void should_insert() {
        ReviewRequest request = ReviewRequestMother.create();
        Review expected = ReviewMother.createReview("test", "test");

        when(reviewMapper.toReview(request)).thenReturn(expected);
        doNothing().when(insertReviewInputPort).insert(expected, request.getAuthorId());

        ResponseEntity<Void> response = reviewController.insert(request);

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode().value());
        verify(insertReviewInputPort, times(1)).insert(expected, request.getAuthorId());
        verify(reviewMapper, times(1)).toReview(request);
    }

    @Test
    public void should_update() {
        String id = "1";
        ReviewRequest request = ReviewRequestMother.create();
        Review expected = ReviewMother.createReview("test", "test");

        when(reviewMapper.toReview(request)).thenReturn(expected);
        doNothing().when(updateReviewInputPort).update(expected, request.getAuthorId());

        ResponseEntity<Void> response = reviewController.update(id, request);

        assertEquals(id, expected.getId());
        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatusCode().value());
        verify(updateReviewInputPort, times(1)).update(expected, request.getAuthorId());
        verify(reviewMapper, times(1)).toReview(request);
    }

    @Test
    public void should_delete_by_id() {
        String id = "1";

        doNothing().when(deleteReviewByIdInputPort).deleteById(id);

        ResponseEntity<Void> response = reviewController.deleteById(id);

        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatusCode().value());
        verify(deleteReviewByIdInputPort, times(1)).deleteById(id);
    }

}