package me.samcefalo.challenge.alura.adapters.out.client;

import me.samcefalo.challenge.alura.adapters.out.client.response.AuthorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name = "FindAddressByZipCodeClient", url = "${author.service.url}")
public interface FindAuthorByIdClient {

    @GetMapping("/{authorId}")
    AuthorResponse findById(@PathVariable("authorId") String authorId);

}
