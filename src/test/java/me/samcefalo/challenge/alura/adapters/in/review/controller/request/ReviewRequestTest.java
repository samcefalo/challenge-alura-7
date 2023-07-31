package me.samcefalo.challenge.alura.adapters.in.review.controller.request;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReviewRequestTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void should_validate_null_authorId() {
        ReviewRequest reviewRequest = ReviewRequestMother.create();
        reviewRequest.setAuthorId(null);

        Set<ConstraintViolation<ReviewRequest>> violations = validator.validate(reviewRequest);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("authorId")));
    }

    @Test
    public void should_validate_empty_authorId() {
        ReviewRequest reviewRequest = ReviewRequestMother.create();
        reviewRequest.setAuthorId("");

        Set<ConstraintViolation<ReviewRequest>> violations = validator.validate(reviewRequest);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("authorId")));
    }

    @Test
    public void should_validate_authorId() {
        ReviewRequest reviewRequest = ReviewRequestMother.create();

        Set<ConstraintViolation<ReviewRequest>> violations = validator.validate(reviewRequest);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void should_validate_null_review() {
        ReviewRequest reviewRequest = ReviewRequestMother.create();
        reviewRequest.setReview(null);

        Set<ConstraintViolation<ReviewRequest>> violations = validator.validate(reviewRequest);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("review")));
    }

    @Test
    public void should_validate_empty_review() {
        ReviewRequest reviewRequest = ReviewRequestMother.create();
        reviewRequest.setReview("");

        Set<ConstraintViolation<ReviewRequest>> violations = validator.validate(reviewRequest);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("review")));
    }

    @Test
    public void should_validate_review() {
        ReviewRequest reviewRequest = ReviewRequestMother.create();

        Set<ConstraintViolation<ReviewRequest>> violations = validator.validate(reviewRequest);

        assertTrue(violations.isEmpty());
    }

}