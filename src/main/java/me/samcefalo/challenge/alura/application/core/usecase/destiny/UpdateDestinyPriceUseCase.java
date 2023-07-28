package me.samcefalo.challenge.alura.application.core.usecase.destiny;

import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.ports.in.destiny.UpdateDestinyPriceInputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.FindDestinyByIdOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.UpdateDestinyOutputPort;

import java.math.BigDecimal;

public class UpdateDestinyPriceUseCase implements UpdateDestinyPriceInputPort {

    private final FindDestinyByIdOutputPort findDestinyByIdOutputPort;
    private final UpdateDestinyOutputPort updateDestinyOutputPort;

    public UpdateDestinyPriceUseCase(FindDestinyByIdOutputPort findDestinyByIdOutputPort, UpdateDestinyOutputPort updateDestinyOutputPort) {
        this.findDestinyByIdOutputPort = findDestinyByIdOutputPort;
        this.updateDestinyOutputPort = updateDestinyOutputPort;
    }

    @Override
    public void updatePrice(String id, BigDecimal price) {
        Destiny destiny = findDestinyByIdOutputPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Destiny not found"));

        destiny.setPrice(price);

        updateDestinyOutputPort.update(destiny);
    }

}
