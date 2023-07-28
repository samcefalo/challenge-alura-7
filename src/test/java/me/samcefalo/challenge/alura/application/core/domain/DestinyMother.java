package me.samcefalo.challenge.alura.application.core.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class DestinyMother {

    public static Destiny createDestiny(String name) {
        Destiny destiny = new Destiny();
        destiny.setId(UUID.randomUUID().toString());
        destiny.setName(name);
        destiny.setDescription(name + " description");
        destiny.setGoal("Goal " + name);
        destiny.setPrice(BigDecimal.valueOf(100.0));
        destiny.getPhotos().add("photo1");
        return destiny;
    }

}
