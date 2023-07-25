package me.samcefalo.challenge.alura.adapters.out.repository.mapper;

import me.samcefalo.challenge.alura.adapters.out.repository.entity.ReviewEntity;
import me.samcefalo.challenge.alura.adapters.out.repository.entity.ReviewEntityMother;
import me.samcefalo.challenge.alura.application.core.domain.Review;
import me.samcefalo.challenge.alura.application.core.domain.ReviewMother;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ReviewEntityMapperTest {

    private final ReviewEntityMapper reviewEntityMapper = Mappers.getMapper(ReviewEntityMapper.class);

    @Test
    public void should_map_domain_to_entity() {
        Review review = ReviewMother.createReview("test", "testName");

        ReviewEntity reviewEntity = reviewEntityMapper.toReviewEntity(review);

        assertEquals(review.getAuthor().getName(), reviewEntity.getAuthor());
        assertEquals(review.getAuthor().getImageUrl(), reviewEntity.getImageUrl());
        assertEquals(review.getReview(), reviewEntity.getReview());
    }

    @Test
    public void should_map_entity_to_domain() {
        ReviewEntity reviewEntity = ReviewEntityMother.createReviewEntity("test", "testName");

        Review review = reviewEntityMapper.toReview(reviewEntity);

        assertEquals(review.getAuthor().getName(), reviewEntity.getAuthor());
        assertEquals(review.getAuthor().getImageUrl(), reviewEntity.getImageUrl());
        assertEquals(review.getReview(), reviewEntity.getReview());
    }

}