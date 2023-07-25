package me.samcefalo.challenge.alura.application.core.domain;

import java.util.UUID;

import static me.samcefalo.challenge.alura.util.DateUtil.now;

public class ReviewMother {

    public static Review createReview(String content, String authorName) {
        Review review = new Review();
        review.setDate(now());
        review.setReview(content);
        review.setId(UUID.randomUUID().toString());
        review.setAuthor(AuthorMother.createAuthor(authorName));
        return review;
    }

}