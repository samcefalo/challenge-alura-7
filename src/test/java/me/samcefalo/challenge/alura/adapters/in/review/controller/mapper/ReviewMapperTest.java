package me.samcefalo.challenge.alura.adapters.in.review.controller.mapper;

import me.samcefalo.challenge.alura.adapters.in.review.controller.request.ReviewRequest;
import me.samcefalo.challenge.alura.adapters.in.review.controller.request.ReviewRequestMother;
import me.samcefalo.challenge.alura.adapters.in.review.controller.response.ReviewResponse;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.core.domain.ReviewMother;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReviewMapperTest {

    private final ReviewMapper reviewMapper = Mappers.getMapper(ReviewMapper.class);

    @Test
    public void should_map_request_to_domain() {
        ReviewRequest reviewRequest = ReviewRequestMother.create();

        Review review = reviewMapper.toReview(reviewRequest);

        assertEquals(reviewRequest.getReview(), review.getReview());
    }

    @Test
    public void should_map_domain_to_response() {
        Review review = ReviewMother.createReview("test", "testName");

        ReviewResponse reviewResponse = reviewMapper.toResponse(review);

        assertEquals(review.getReview(), reviewResponse.getReview());
        assertEquals(review.getAuthor().getName(), reviewResponse.getAuthor());
        assertEquals(review.getAuthor().getImageUrl(), reviewResponse.getImageUrl());
    }
}