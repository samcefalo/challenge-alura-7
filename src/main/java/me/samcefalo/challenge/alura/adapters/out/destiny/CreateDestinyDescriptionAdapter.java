package me.samcefalo.challenge.alura.adapters.out.destiny;

import me.samcefalo.challenge.alura.adapters.out.destiny.ia.FindDestinyDescriptionWithIA;
import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.ports.out.destiny.CreateDestinyDescriptionOutputPort;
import org.springframework.stereotype.Component;

@Component
public class CreateDestinyDescriptionAdapter implements CreateDestinyDescriptionOutputPort {

    private final FindDestinyDescriptionWithIA findDestinyDescriptionWithIA;

    public CreateDestinyDescriptionAdapter(FindDestinyDescriptionWithIA findDestinyDescriptionWithIA) {
        this.findDestinyDescriptionWithIA = findDestinyDescriptionWithIA;
    }

    @Override
    public String createDescription(Destiny destiny) {
        return findDestinyDescriptionWithIA.findDescription(destiny.getName());
    }
}
