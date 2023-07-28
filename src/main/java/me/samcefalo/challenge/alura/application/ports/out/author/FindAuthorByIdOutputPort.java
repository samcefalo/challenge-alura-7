package me.samcefalo.challenge.alura.application.ports.out.author;

import me.samcefalo.challenge.alura.application.core.domain.Author;

public interface FindAuthorByIdOutputPort {

    Author findById(String id);

}
