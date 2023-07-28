package me.samcefalo.challenge.alura.adapters.out.author;

import me.samcefalo.challenge.alura.adapters.out.author.client.FindAuthorByIdClient;
import me.samcefalo.challenge.alura.adapters.out.author.client.mapper.AuthorMapper;
import me.samcefalo.challenge.alura.adapters.out.author.client.response.AuthorResponse;
import me.samcefalo.challenge.alura.application.core.domain.Author;
import me.samcefalo.challenge.alura.application.ports.out.author.FindAuthorByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAuthorByIdAdapter implements FindAuthorByIdOutputPort {

    private final FindAuthorByIdClient findAuthorByIdClient;
    private final AuthorMapper authorMapper;

    @Autowired
    public FindAuthorByIdAdapter(FindAuthorByIdClient findAuthorByIdClient, AuthorMapper authorMapper) {
        this.findAuthorByIdClient = findAuthorByIdClient;
        this.authorMapper = authorMapper;
    }

    @Override
    public Author findById(String id) {
        AuthorResponse authorResponse = findAuthorByIdClient.findById(id);
        return authorMapper.toAuthor(authorResponse);
    }

}
