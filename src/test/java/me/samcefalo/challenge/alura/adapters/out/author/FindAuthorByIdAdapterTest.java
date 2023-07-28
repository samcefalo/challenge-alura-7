package me.samcefalo.challenge.alura.adapters.out.author;

import me.samcefalo.challenge.alura.adapters.out.author.client.FindAuthorByIdClient;
import me.samcefalo.challenge.alura.adapters.out.author.client.mapper.AuthorMapper;
import me.samcefalo.challenge.alura.adapters.out.author.client.response.AuthorResponse;
import me.samcefalo.challenge.alura.adapters.out.author.client.response.AuthorResponseMother;
import me.samcefalo.challenge.alura.application.core.domain.Author;
import me.samcefalo.challenge.alura.application.core.domain.AuthorMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class FindAuthorByIdAdapterTest {

    private FindAuthorByIdClient findAuthorByIdClient;
    private AuthorMapper authorMapper;
    private FindAuthorByIdAdapter findAuthorByIdAdapter;

    @BeforeEach
    void setUp() {
        findAuthorByIdClient = mock(FindAuthorByIdClient.class);
        authorMapper = mock(AuthorMapper.class);
        findAuthorByIdAdapter = new FindAuthorByIdAdapter(findAuthorByIdClient, authorMapper);
    }

    @Test
    public void should_find_author_by_id() {
        String id = "id";
        Author expected = AuthorMother.createAuthor("test");
        AuthorResponse expectedResponse = AuthorResponseMother.create();

        when(findAuthorByIdClient.findById(id)).thenReturn(expectedResponse);
        when(authorMapper.toAuthor(expectedResponse)).thenReturn(expected);

        Author response = findAuthorByIdAdapter.findById(id);

        assertNotNull(response);
        assertEquals(expected, response);
        verify(findAuthorByIdClient, times(1)).findById(id);
        verify(authorMapper, times(1)).toAuthor(expectedResponse);
    }
}