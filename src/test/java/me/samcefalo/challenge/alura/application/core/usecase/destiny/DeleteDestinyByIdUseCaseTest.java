package me.samcefalo.challenge.alura.application.core.usecase.destiny;

import me.samcefalo.challenge.alura.application.ports.out.destiny.DeleteDestinyByIdOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class DeleteDestinyByIdUseCaseTest {
    private DeleteDestinyByIdOutputPort deleteDestinyByIdOutputPort;
    private DeleteDestinyByIdUseCase deleteDestinyByIdUseCase;

    @BeforeEach
    void setup() {
        deleteDestinyByIdOutputPort = mock(DeleteDestinyByIdOutputPort.class);
        deleteDestinyByIdUseCase = new DeleteDestinyByIdUseCase(deleteDestinyByIdOutputPort);
    }

    @Test
    public void should_delete_destiny_by_id() {
        String id = "id";

        doNothing().when(deleteDestinyByIdOutputPort).deleteById(id);

        deleteDestinyByIdUseCase.deleteById(id);

        verify(deleteDestinyByIdOutputPort).deleteById(id);
    }

}