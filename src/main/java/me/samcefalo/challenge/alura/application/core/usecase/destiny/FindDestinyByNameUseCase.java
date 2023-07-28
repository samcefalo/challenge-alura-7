package me.samcefalo.challenge.alura.application.core.usecase.destiny;

import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.ports.in.destiny.FindDestinyByNameInputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.FindDestinyByNameOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.rating.FindDestinyRatingOutputPort;

import java.util.List;

public class FindDestinyByNameUseCase implements FindDestinyByNameInputPort {

    private final FindDestinyByNameOutputPort findDestinyByNameOutputPort;
    private final FindDestinyRatingOutputPort findDestinyRatingOutputPort;

    public FindDestinyByNameUseCase(FindDestinyByNameOutputPort findDestinyByNameOutputPort, FindDestinyRatingOutputPort findDestinyRatingOutputPort) {
        this.findDestinyByNameOutputPort = findDestinyByNameOutputPort;
        this.findDestinyRatingOutputPort = findDestinyRatingOutputPort;
    }

    @Override
    public List<Destiny> findByName(String name) {
        List<Destiny> destiny = findDestinyByNameOutputPort.findByName(name);

        destiny.forEach(d -> d.setRating(findDestinyRatingOutputPort.findDestinyRating(d.getId())));

        return destiny;
    }

}
