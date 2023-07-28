package me.samcefalo.challenge.alura.adapters.out.author.client.mapper;

import me.samcefalo.challenge.alura.adapters.out.author.client.response.AuthorResponse;
import me.samcefalo.challenge.alura.application.core.domain.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toAuthor(AuthorResponse authorResponse);

}
