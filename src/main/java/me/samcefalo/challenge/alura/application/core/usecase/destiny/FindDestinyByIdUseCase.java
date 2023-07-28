package me.samcefalo.challenge.alura.application.core.usecase.destiny;

import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.ports.in.destiny.FindDestinyByIdInputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.FindDestinyByIdOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.rating.FindDestinyRatingOutputPort;

public class FindDestinyByIdUseCase implements FindDestinyByIdInputPort {

    private final FindDestinyByIdOutputPort findDestinyByIdOutputPort;
    private final FindDestinyRatingOutputPort findDestinyRatingOutputPort;

    public FindDestinyByIdUseCase(FindDestinyByIdOutputPort findDestinyByIdOutputPort, FindDestinyRatingOutputPort findDestinyRatingOutputPort) {
        this.findDestinyByIdOutputPort = findDestinyByIdOutputPort;
        this.findDestinyRatingOutputPort = findDestinyRatingOutputPort;
    }

    @Override
    public Destiny findById(String id) {
        Destiny destiny = findDestinyByIdOutputPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Destiny not found"));

        destiny.setRating(findDestinyRatingOutputPort.findDestinyRating(id));

        return destiny;
    }

}
