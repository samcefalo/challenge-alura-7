package me.samcefalo.challenge.alura.adapters.in.destiny.controller.mapper;

import me.samcefalo.challenge.alura.adapters.in.destiny.controller.request.DestinyRequest;
import me.samcefalo.challenge.alura.adapters.in.destiny.controller.response.DestinyResponse;
import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DestinyMapper {

    Destiny toDestiny(DestinyRequest destinyRequest);

    DestinyResponse toResponse(Destiny destiny);

}
