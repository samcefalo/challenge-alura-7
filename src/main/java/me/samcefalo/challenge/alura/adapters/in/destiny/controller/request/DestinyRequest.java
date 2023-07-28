package me.samcefalo.challenge.alura.adapters.in.destiny.controller.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
public class DestinyRequest {

    @NotBlank
    private String name;
    private Set<String> photos = new HashSet<>();
    private String description;
    @NotBlank
    @Size(max = 160)
    private String goal;
    @NotNull
    @Min(0)
    private BigDecimal price;

}
