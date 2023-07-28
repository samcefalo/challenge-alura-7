package me.samcefalo.challenge.alura.adapters.in.destiny.controller.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DestinyPriceRequest {

    @NotNull
    @Min(0)
    private BigDecimal price;

}
