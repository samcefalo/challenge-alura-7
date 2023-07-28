package me.samcefalo.challenge.alura.application.core.usecase.destiny;

import me.samcefalo.challenge.alura.application.ports.in.destiny.DeleteDestinyByIdInputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.DeleteDestinyByIdOutputPort;

public class DeleteDestinyByIdUseCase implements DeleteDestinyByIdInputPort {

    private final DeleteDestinyByIdOutputPort deleteDestinyByIdOutputPort;

    public DeleteDestinyByIdUseCase(DeleteDestinyByIdOutputPort deleteDestinyByIdOutputPort) {
        this.deleteDestinyByIdOutputPort = deleteDestinyByIdOutputPort;
    }

    @Override
    public void deleteById(String id) {
        deleteDestinyByIdOutputPort.deleteById(id);
    }
}
