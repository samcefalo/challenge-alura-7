package me.samcefalo.challenge.alura.application.ports.in;

import me.samcefalo.challenge.alura.application.core.domain.Review;

public interface FindReviewByIdInputPort {

    Review findById(String id);

}
