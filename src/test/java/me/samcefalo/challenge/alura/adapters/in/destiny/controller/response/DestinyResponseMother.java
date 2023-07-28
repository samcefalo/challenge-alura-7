package me.samcefalo.challenge.alura.adapters.in.destiny.controller.response;


import java.math.BigDecimal;

public class DestinyResponseMother {

    public static DestinyResponse create() {
        DestinyResponse destinyResponse = new DestinyResponse();
        destinyResponse.setName("destiny");
        destinyResponse.setDescription("description");
        destinyResponse.setRating(5.0);
        destinyResponse.setPrice(BigDecimal.valueOf(100));
        destinyResponse.setGoal("goal");
        destinyResponse.getPhotos().add("photo1");
        return destinyResponse;
    }

}