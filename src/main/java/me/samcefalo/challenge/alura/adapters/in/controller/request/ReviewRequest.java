package me.samcefalo.challenge.alura.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReviewRequest {

    @NotBlank
    private String authorId;
    @NotBlank
    private String review;

}
