package me.samcefalo.challenge.alura.adapters.in.destiny.controller.request;

import java.math.BigDecimal;

public class DestinyRequestMother {

    public static DestinyRequest create() {
        DestinyRequest destinyRequest = new DestinyRequest();
        destinyRequest.setName("destiny");
        destinyRequest.setDescription("description");
        destinyRequest.setGoal("test");
        destinyRequest.setPrice(BigDecimal.valueOf(100));
        destinyRequest.getPhotos().add("photo1");
        return destinyRequest;
    }

}