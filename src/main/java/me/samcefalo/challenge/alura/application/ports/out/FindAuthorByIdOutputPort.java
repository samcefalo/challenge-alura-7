package me.samcefalo.challenge.alura.application.ports.out;

import me.samcefalo.challenge.alura.application.core.domain.Author;

public interface FindAuthorByIdOutputPort {

    Author findById(String id);

}
