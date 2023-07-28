package me.samcefalo.challenge.alura.application.ports.out.destiny;

import me.samcefalo.challenge.alura.application.core.domain.Destiny;

import java.util.List;

public interface FindDestinyByNameOutputPort {

    List<Destiny> findByName(String name);

}
