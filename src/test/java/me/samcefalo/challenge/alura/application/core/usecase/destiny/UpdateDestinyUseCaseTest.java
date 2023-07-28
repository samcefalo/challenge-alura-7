package me.samcefalo.challenge.alura.application.core.usecase.destiny;

import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.core.domain.DestinyMother;
import me.samcefalo.challenge.alura.application.ports.out.destiny.UpdateDestinyOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class UpdateDestinyUseCaseTest {

    private UpdateDestinyOutputPort updateDestinyOutputPort;
    private UpdateDestinyUseCase updateDestinyUseCase;

    @BeforeEach
    void setup() {
        updateDestinyOutputPort = mock(UpdateDestinyOutputPort.class);
        updateDestinyUseCase = new UpdateDestinyUseCase(updateDestinyOutputPort);
    }

    @Test
    public void should_update_destiny() {
        Destiny destiny = DestinyMother.createDestiny("test");

        doNothing().when(updateDestinyOutputPort).update(destiny);

        updateDestinyUseCase.update(destiny);

        verify(updateDestinyOutputPort, times(1)).update(destiny);
    }
}