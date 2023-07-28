package me.samcefalo.challenge.alura.adapters.out.destiny.repository.entity;

import java.math.BigDecimal;

public class DestinyEntityMother {

    public static DestinyEntity createDestinyEntity(String name) {
        DestinyEntity destinyEntity = new DestinyEntity();
        destinyEntity.setName(name);
        destinyEntity.setDescription(name + " description");
        destinyEntity.setGoal("Goal " + name);
        destinyEntity.setPrice(BigDecimal.valueOf(100.0));
        destinyEntity.getPhotos().add("photo1");
        return destinyEntity;
    }

}