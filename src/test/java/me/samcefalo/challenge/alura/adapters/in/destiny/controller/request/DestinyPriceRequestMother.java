package me.samcefalo.challenge.alura.adapters.in.destiny.controller.request;

import java.math.BigDecimal;


public class DestinyPriceRequestMother {

    public static DestinyPriceRequest create() {
        DestinyPriceRequest destinyPriceRequest = new DestinyPriceRequest();
        destinyPriceRequest.setPrice(BigDecimal.TEN);
        return destinyPriceRequest;
    }
}