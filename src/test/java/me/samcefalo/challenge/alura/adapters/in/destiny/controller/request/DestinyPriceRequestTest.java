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

class DestinyPriceRequestTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void should_validate_null_price() {
        DestinyPriceRequest destinyPriceRequest = DestinyPriceRequestMother.create();
        destinyPriceRequest.setPrice(null);

        Set<ConstraintViolation<DestinyPriceRequest>> violations = validator.validate(destinyPriceRequest);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("price")));
    }

    @Test
    public void should_validate_negative_price() {
        DestinyPriceRequest destinyPriceRequest = DestinyPriceRequestMother.create();
        destinyPriceRequest.setPrice(BigDecimal.valueOf(-1));

        Set<ConstraintViolation<DestinyPriceRequest>> violations = validator.validate(destinyPriceRequest);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(violation -> violation.getPropertyPath().toString().equals("price")));
    }

    @Test
    public void should_validate_min_price() {
        DestinyPriceRequest destinyPriceRequest = DestinyPriceRequestMother.create();
        destinyPriceRequest.setPrice(BigDecimal.valueOf(0));

        Set<ConstraintViolation<DestinyPriceRequest>> violations = validator.validate(destinyPriceRequest);

        assertTrue(violations.isEmpty());
    }


    @Test
    public void should_validate_price() {
        DestinyPriceRequest destinyPriceRequest = DestinyPriceRequestMother.create();

        Set<ConstraintViolation<DestinyPriceRequest>> violations = validator.validate(destinyPriceRequest);

        assertTrue(violations.isEmpty());
    }

}