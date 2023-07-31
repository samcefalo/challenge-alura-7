package me.samcefalo.challenge.alura.adapters.in.destiny.controller.request;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DestinyRequestTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void should_validate_null_name() {
        DestinyRequest destinyRequest = DestinyRequestMother.create();
        destinyRequest.setName(null);

        Set<ConstraintViolation<DestinyRequest>> violations = validator.validate(destinyRequest);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("name")));
    }

    @Test
    public void should_validate_empty_name() {
        DestinyRequest destinyRequest = DestinyRequestMother.create();
        destinyRequest.setName("");

        Set<ConstraintViolation<DestinyRequest>> violations = validator.validate(destinyRequest);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("name")));
    }

    @Test
    public void should_validate_name() {
        DestinyRequest destinyRequest = DestinyRequestMother.create();

        Set<ConstraintViolation<DestinyRequest>> violations = validator.validate(destinyRequest);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void should_validate_null_goal() {
        DestinyRequest destinyRequest = DestinyRequestMother.create();
        destinyRequest.setGoal(null);

        Set<ConstraintViolation<DestinyRequest>> violations = validator.validate(destinyRequest);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("goal")));
    }

    @Test
    public void should_validate_empty_goal() {
        DestinyRequest destinyRequest = DestinyRequestMother.create();
        destinyRequest.setGoal("");

        Set<ConstraintViolation<DestinyRequest>> violations = validator.validate(destinyRequest);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("goal")));
    }

    @Test
    public void should_validate_max_size_goal() {
        DestinyRequest destinyRequest = DestinyRequestMother.create();
        destinyRequest.setGoal("1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        Set<ConstraintViolation<DestinyRequest>> violations = validator.validate(destinyRequest);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("goal")));
    }

    @Test
    public void should_validate_goal() {
        DestinyRequest destinyRequest = DestinyRequestMother.create();

        Set<ConstraintViolation<DestinyRequest>> violations = validator.validate(destinyRequest);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void should_validate_null_price() {
        DestinyRequest destinyRequest = DestinyRequestMother.create();
        destinyRequest.setPrice(null);

        Set<ConstraintViolation<DestinyRequest>> violations = validator.validate(destinyRequest);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("price")));
    }

    @Test
    public void should_validate_negative_price() {
        DestinyRequest destinyRequest = DestinyRequestMother.create();
        destinyRequest.setPrice(BigDecimal.valueOf(-1));

        Set<ConstraintViolation<DestinyRequest>> violations = validator.validate(destinyRequest);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("price")));
    }

    @Test
    public void should_validate_min_price() {
        DestinyRequest destinyRequest = DestinyRequestMother.create();
        destinyRequest.setPrice(BigDecimal.valueOf(0));

        Set<ConstraintViolation<DestinyRequest>> violations = validator.validate(destinyRequest);

        assertTrue(violations.isEmpty());
    }


    @Test
    public void should_validate_price() {
        DestinyRequest destinyRequest = DestinyRequestMother.create();

        Set<ConstraintViolation<DestinyRequest>> violations = validator.validate(destinyRequest);

        assertTrue(violations.isEmpty());
    }

}