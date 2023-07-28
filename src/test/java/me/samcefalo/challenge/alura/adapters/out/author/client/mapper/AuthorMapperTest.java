package me.samcefalo.challenge.alura.adapters.out.author.client.mapper;

import me.samcefalo.challenge.alura.adapters.out.author.client.response.AuthorResponse;
import me.samcefalo.challenge.alura.adapters.out.author.client.response.AuthorResponseMother;
import me.samcefalo.challenge.alura.application.core.domain.Author;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorMapperTest {

    private final AuthorMapper authorMapper = Mappers.getMapper(AuthorMapper.class);

    @Test
    public void should_map_response_to_domain() {
        AuthorResponse authorResponse = AuthorResponseMother.create();

        Author author = authorMapper.toAuthor(authorResponse);

        assertEquals(authorResponse.getName(), author.getName());
        assertEquals(authorResponse.getImageUrl(), author.getImageUrl());
        assertEquals(authorResponse.getEmail(), author.getEmail());
    }

}