package me.samcefalo.challenge.alura.application.core.usecase.destiny;

import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.ports.in.destiny.InsertDestinyInputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.CreateDestinyDescriptionOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.InsertDestinyOutputPort;

import java.util.Objects;

public class InsertDestinyUseCase implements InsertDestinyInputPort {

    private final InsertDestinyOutputPort insertDestinyOutputPort;
    private final CreateDestinyDescriptionOutputPort createDestinyDescriptionOutputPort;

    public InsertDestinyUseCase(InsertDestinyOutputPort insertDestinyOutputPort, CreateDestinyDescriptionOutputPort createDestinyDescriptionOutputPort) {
        this.insertDestinyOutputPort = insertDestinyOutputPort;
        this.createDestinyDescriptionOutputPort = createDestinyDescriptionOutputPort;
    }

    @Override
    public void insert(Destiny destiny) {
        if (Objects.isNull(destiny.getDescription())) {
            destiny.setDescription(createDestinyDescriptionOutputPort.createDescription(destiny));
        }

        insertDestinyOutputPort.insert(destiny);
    }

}
