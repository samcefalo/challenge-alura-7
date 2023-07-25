package me.samcefalo.challenge.alura.adapters.out;

import me.samcefalo.challenge.alura.adapters.out.client.FindAuthorByIdClient;
import me.samcefalo.challenge.alura.adapters.out.client.mapper.AuthorMapper;
import me.samcefalo.challenge.alura.adapters.out.client.response.AuthorResponse;
import me.samcefalo.challenge.alura.application.core.domain.Author;
import me.samcefalo.challenge.alura.application.ports.out.FindAuthorByIdOutputPort;
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
