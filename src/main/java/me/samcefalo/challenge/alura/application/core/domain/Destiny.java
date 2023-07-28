package me.samcefalo.challenge.alura.application.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Destiny {

    private String id;
    private String name;
    private double rating;
    private final Set<String> photos = new HashSet<>();
    private String description;
    private String goal;
    private BigDecimal price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Set<String> getPhotos() {
        return photos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
