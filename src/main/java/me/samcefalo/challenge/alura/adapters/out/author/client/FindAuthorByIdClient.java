package me.samcefalo.challenge.alura.adapters.out.author.client;

import me.samcefalo.challenge.alura.adapters.out.author.client.response.AuthorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name = "FindAuthorByIdClient", url = "${author.service.url}")
public interface FindAuthorByIdClient {

    @GetMapping("/{authorId}")
    AuthorResponse findById(@PathVariable("authorId") String authorId);

}
