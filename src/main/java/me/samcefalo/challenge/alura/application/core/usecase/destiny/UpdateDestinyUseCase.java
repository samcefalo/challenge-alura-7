package me.samcefalo.challenge.alura.application.core.usecase.destiny;

import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.ports.in.destiny.UpdateDestinyInputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.UpdateDestinyOutputPort;

public class UpdateDestinyUseCase implements UpdateDestinyInputPort {

    private final UpdateDestinyOutputPort updateDestinyOutputPort;

    public UpdateDestinyUseCase(UpdateDestinyOutputPort updateDestinyOutputPort) {
        this.updateDestinyOutputPort = updateDestinyOutputPort;
    }

    @Override
    public void update(Destiny destiny) {
        updateDestinyOutputPort.update(destiny);
    }
}
