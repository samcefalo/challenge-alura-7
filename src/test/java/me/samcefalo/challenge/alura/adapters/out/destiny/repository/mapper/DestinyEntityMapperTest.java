package me.samcefalo.challenge.alura.adapters.out.destiny.repository.mapper;

import me.samcefalo.challenge.alura.adapters.out.destiny.repository.entity.DestinyEntity;
import me.samcefalo.challenge.alura.adapters.out.destiny.repository.entity.DestinyEntityMother;
import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.core.domain.DestinyMother;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DestinyEntityMapperTest {

    private final DestinyEntityMapper destinyEntityMapper = Mappers.getMapper(DestinyEntityMapper.class);

    @Test
    public void should_map_domain_to_entity() {
        Destiny destiny = DestinyMother.createDestiny("test");

        DestinyEntity destinyEntity = destinyEntityMapper.toDestinyEntity(destiny);

        assertEquals(destiny.getName(), destinyEntity.getName());
        assertEquals(destiny.getId(), destinyEntity.getId());
        assertEquals(destiny.getDescription(), destinyEntity.getDescription());
        assertEquals(destiny.getGoal(), destinyEntity.getGoal());
        assertEquals(destiny.getPrice(), destinyEntity.getPrice());
        assertEquals(destiny.getPhotos(), destinyEntity.getPhotos());
    }

    @Test
    public void should_map_entity_to_domain() {
        DestinyEntity destinyEntity = DestinyEntityMother.createDestinyEntity("test");

        Destiny destiny = destinyEntityMapper.toDestiny(destinyEntity);

        assertEquals(destinyEntity.getName(), destiny.getName());
        assertEquals(destinyEntity.getId(), destiny.getId());
        assertEquals(destinyEntity.getDescription(), destiny.getDescription());
        assertEquals(destinyEntity.getGoal(), destiny.getGoal());
        assertEquals(destinyEntity.getPrice(), destiny.getPrice());
        assertEquals(destinyEntity.getPhotos(), destiny.getPhotos());
    }
}