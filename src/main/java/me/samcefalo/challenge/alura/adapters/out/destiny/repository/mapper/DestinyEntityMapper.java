package me.samcefalo.challenge.alura.adapters.out.destiny.repository.mapper;

import me.samcefalo.challenge.alura.adapters.out.destiny.repository.entity.DestinyEntity;
import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DestinyEntityMapper {

    DestinyEntity toDestinyEntity(Destiny destiny);

    Destiny toDestiny(DestinyEntity entity);
}
