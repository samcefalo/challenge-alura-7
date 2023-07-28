package me.samcefalo.challenge.alura.application.ports.in.destiny;

import me.samcefalo.challenge.alura.application.core.domain.Destiny;

public interface FindDestinyByIdInputPort {

    Destiny findById(String id);

}
