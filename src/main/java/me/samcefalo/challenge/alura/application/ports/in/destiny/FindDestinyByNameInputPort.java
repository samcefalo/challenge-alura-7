package me.samcefalo.challenge.alura.application.ports.in.destiny;

import me.samcefalo.challenge.alura.application.core.domain.Destiny;

import java.util.List;

public interface FindDestinyByNameInputPort {

    List<Destiny> findByName(String name);

}
