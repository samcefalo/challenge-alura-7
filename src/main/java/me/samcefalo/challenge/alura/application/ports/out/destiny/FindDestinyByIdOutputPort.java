package me.samcefalo.challenge.alura.application.ports.out.destiny;

import me.samcefalo.challenge.alura.application.core.domain.Destiny;

import java.util.Optional;

public interface FindDestinyByIdOutputPort {

    Optional<Destiny> findById(String id);

}
