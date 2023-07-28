package me.samcefalo.challenge.alura.adapters.out.rating.client;

import me.samcefalo.challenge.alura.adapters.out.rating.client.response.RatingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name = "FindDestinyRatingClient", url = "${rating.service.url}")
public interface FindDestinyRatingClient {

    @GetMapping("/{destinyId}")
    RatingResponse findById(@PathVariable("destinyId") String destinyId);

}
