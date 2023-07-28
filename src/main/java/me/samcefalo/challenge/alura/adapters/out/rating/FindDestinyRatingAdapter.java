package me.samcefalo.challenge.alura.adapters.out.rating;

import me.samcefalo.challenge.alura.adapters.out.rating.client.FindDestinyRatingClient;
import me.samcefalo.challenge.alura.application.ports.out.rating.FindDestinyRatingOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindDestinyRatingAdapter implements FindDestinyRatingOutputPort {

    private final FindDestinyRatingClient findDestinyRatingClient;

    @Autowired
    public FindDestinyRatingAdapter(FindDestinyRatingClient findDestinyRatingClient) {
        this.findDestinyRatingClient = findDestinyRatingClient;
    }

    @Override
    public Double findDestinyRating(String destinyId) {
        return findDestinyRatingClient.findById(destinyId).getAverage();
    }

}
