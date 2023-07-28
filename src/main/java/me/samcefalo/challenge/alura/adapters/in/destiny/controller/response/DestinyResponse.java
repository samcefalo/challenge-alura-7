package me.samcefalo.challenge.alura.adapters.in.destiny.controller.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
public class DestinyResponse {

    private String name;
    private Double rating;
    private Set<String> photos = new HashSet<>();
    private String description;
    private String goal;
    private BigDecimal price;

}
