package me.samcefalo.challenge.alura.application.ports.in.destiny;

import java.math.BigDecimal;

public interface UpdateDestinyPriceInputPort {

    void updatePrice(String id, BigDecimal price);

}
