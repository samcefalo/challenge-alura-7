package me.samcefalo.challenge.alura.adapters.in.controller.request;

public class ReviewRequestMother {

    public static ReviewRequest create() {
        ReviewRequest reviewRequest = new ReviewRequest();
        reviewRequest.setAuthorId("authorId");
        reviewRequest.setReview("review");
        return reviewRequest;
    }

}