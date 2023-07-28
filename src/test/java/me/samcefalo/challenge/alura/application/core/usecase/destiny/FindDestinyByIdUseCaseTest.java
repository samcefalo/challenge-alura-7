package me.samcefalo.challenge.alura.application.core.usecase.destiny;

import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.core.domain.DestinyMother;
import me.samcefalo.challenge.alura.application.ports.out.destiny.FindDestinyByIdOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.rating.FindDestinyRatingOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class FindDestinyByIdUseCaseTest {

    private FindDestinyByIdOutputPort findDestinyByIdOutputPort;
    private FindDestinyRatingOutputPort findDestinyRatingOutputPort;
    private FindDestinyByIdUseCase findDestinyByIdUseCase;

    @BeforeEach
    void setUp() {
        findDestinyByIdOutputPort = mock(FindDestinyByIdOutputPort.class);
        findDestinyRatingOutputPort = mock(FindDestinyRatingOutputPort.class);
        findDestinyByIdUseCase = new FindDestinyByIdUseCase(findDestinyByIdOutputPort, findDestinyRatingOutputPort);
    }

    @Test
    public void should_find_destiny_by_id() {
        String id = "1";
        Double expectedRating = 5.0;
        Destiny expected = DestinyMother.createDestiny("test");

        when(findDestinyByIdOutputPort.findById(id)).thenReturn(Optional.of(expected));
        when(findDestinyRatingOutputPort.findDestinyRating(id)).thenReturn(expectedRating);

        Destiny destiny = findDestinyByIdUseCase.findById(id);

        assertEquals(expected, destiny);
        assertEquals(expectedRating, destiny.getRating());
        verify(findDestinyRatingOutputPort, times(1)).findDestinyRating(anyString());
        verify(findDestinyByIdOutputPort, times(1)).findById(anyString());
    }

    @Test
    public void should_not_find_destiny_by_id() {
        String id = "1";

        when(findDestinyByIdOutputPort.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> findDestinyByIdUseCase.findById(id));

        verify(findDestinyByIdOutputPort, times(1)).findById(anyString());
        verify(findDestinyRatingOutputPort, never()).findDestinyRating(anyString());
    }
}