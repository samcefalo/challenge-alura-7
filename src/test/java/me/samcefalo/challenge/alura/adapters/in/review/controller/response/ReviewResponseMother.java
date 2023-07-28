package me.samcefalo.challenge.alura.adapters.in.review.controller.response;

public class ReviewResponseMother {

    public static ReviewResponse create() {
        ReviewResponse reviewResponse = new ReviewResponse();
        reviewResponse.setAuthor("author");
        reviewResponse.setImageUrl("imageUrl");
        reviewResponse.setReview("review");
        return reviewResponse;
    }
}