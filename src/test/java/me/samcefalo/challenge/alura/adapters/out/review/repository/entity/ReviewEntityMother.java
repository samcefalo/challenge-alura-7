package me.samcefalo.challenge.alura.adapters.out.review.repository.entity;

import java.util.UUID;

import static me.samcefalo.challenge.alura.util.DateUtil.now;

public class ReviewEntityMother {

    public static ReviewEntity createReviewEntity(String content, String authorName) {
        ReviewEntity review = new ReviewEntity();
        review.setDate(now());
        review.setReview(content);
        review.setId(UUID.randomUUID().toString());
        review.setAuthor(authorName);
        review.setImageUrl("http://image.com/" + authorName);
        return review;
    }

}