package me.samcefalo.challenge.alura.adapters.in.destiny.controller.mapper;

import me.samcefalo.challenge.alura.adapters.in.destiny.controller.request.DestinyRequest;
import me.samcefalo.challenge.alura.adapters.in.destiny.controller.request.DestinyRequestMother;
import me.samcefalo.challenge.alura.adapters.in.destiny.controller.response.DestinyResponse;
import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.core.domain.DestinyMother;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DestinyMapperTest {

    private final DestinyMapper destinyMapper = Mappers.getMapper(DestinyMapper.class);

    @Test
    public void should_map_request_to_domain() {
        DestinyRequest destinyRequest = DestinyRequestMother.create();

        Destiny destiny = destinyMapper.toDestiny(destinyRequest);

        assertEquals(destinyRequest.getName(), destiny.getName());
        assertEquals(destinyRequest.getPhotos(), destiny.getPhotos());
        assertEquals(destinyRequest.getDescription(), destiny.getDescription());
        assertEquals(destinyRequest.getGoal(), destiny.getGoal());
        assertEquals(destinyRequest.getPrice(), destiny.getPrice());
    }

    @Test
    public void should_map_domain_to_response() {
        Destiny destiny = DestinyMother.createDestiny("test");

        DestinyResponse destinyResponse = destinyMapper.toResponse(destiny);

        assertEquals(destiny.getName(), destinyResponse.getName());
        assertEquals(destiny.getPhotos(), destinyResponse.getPhotos());
        assertEquals(destiny.getDescription(), destinyResponse.getDescription());
    }
}