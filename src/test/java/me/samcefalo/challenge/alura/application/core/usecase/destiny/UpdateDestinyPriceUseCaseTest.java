package me.samcefalo.challenge.alura.application.core.usecase.destiny;

import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.core.domain.DestinyMother;
import me.samcefalo.challenge.alura.application.ports.out.destiny.FindDestinyByIdOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.UpdateDestinyOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class UpdateDestinyPriceUseCaseTest {

    private FindDestinyByIdOutputPort findDestinyByIdOutputPort;
    private UpdateDestinyOutputPort updateDestinyOutputPort;
    private UpdateDestinyPriceUseCase updateDestinyPriceUseCase;

    @BeforeEach
    void setup() {
        findDestinyByIdOutputPort = mock(FindDestinyByIdOutputPort.class);
        updateDestinyOutputPort = mock(UpdateDestinyOutputPort.class);
        updateDestinyPriceUseCase = new UpdateDestinyPriceUseCase(findDestinyByIdOutputPort, updateDestinyOutputPort);
    }

    @Test
    public void should_update_price() {
        String id = "1";
        BigDecimal price = BigDecimal.valueOf(100);
        Destiny expected = DestinyMother.createDestiny("test");

        when(findDestinyByIdOutputPort.findById(id)).thenReturn(Optional.of(expected));
        doNothing().when(updateDestinyOutputPort).update(expected);

        updateDestinyPriceUseCase.updatePrice(id, price);

        assertEquals(price, expected.getPrice());
        verify(findDestinyByIdOutputPort, times(1)).findById(id);
        verify(updateDestinyOutputPort, times(1)).update(expected);
    }

    @Test
    public void should_not_update_price() {
        String id = "1";
        BigDecimal price = BigDecimal.valueOf(100);

        when(findDestinyByIdOutputPort.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> updateDestinyPriceUseCase.updatePrice(id, price));

        verify(findDestinyByIdOutputPort, times(1)).findById(id);
        verify(updateDestinyOutputPort, never()).update(any(Destiny.class));
    }
}
