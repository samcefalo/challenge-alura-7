package me.samcefalo.challenge.alura.application.core.usecase.destiny;

import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.core.domain.DestinyMother;
import me.samcefalo.challenge.alura.application.ports.out.destiny.FindDestinyByNameOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.rating.FindDestinyRatingOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class FindDestinyByNameUseCaseTest {

    private FindDestinyByNameOutputPort findDestinyByNameOutputPort;
    private FindDestinyRatingOutputPort findDestinyRatingOutputPort;
    private FindDestinyByNameUseCase findDestinyByNameUseCase;

    @BeforeEach
    void setUp() {
        findDestinyByNameOutputPort = mock(FindDestinyByNameOutputPort.class);
        findDestinyRatingOutputPort = mock(FindDestinyRatingOutputPort.class);
        findDestinyByNameUseCase = new FindDestinyByNameUseCase(findDestinyByNameOutputPort, findDestinyRatingOutputPort);
    }

    @Test
    public void should_find_destiny_by_name() {
        String name = "1";
        Double expectedRating = 5.0;
        List<Destiny> expected = List.of(DestinyMother.createDestiny("test"),
                DestinyMother.createDestiny("test2"));

        when(findDestinyByNameOutputPort.findByName(name)).thenReturn(expected);
        when(findDestinyRatingOutputPort.findDestinyRating(anyString())).thenReturn(expectedRating);

        List<Destiny> destinations = findDestinyByNameUseCase.findByName(name);

        assertFalse(destinations.isEmpty());
        assertEquals(expected.size(), destinations.size());
        verify(findDestinyByNameOutputPort, times(1)).findByName(name);
        verify(findDestinyRatingOutputPort, times(expected.size())).findDestinyRating(anyString());
    }

    @Test
    public void should_not_find_destiny_by_name() {
        String name = "1";

        when(findDestinyByNameOutputPort.findByName(name)).thenReturn(List.of());

        List<Destiny> destinations = findDestinyByNameUseCase.findByName(name);

        assertTrue(destinations.isEmpty());

        verify(findDestinyByNameOutputPort, times(1)).findByName(name);
        verify(findDestinyRatingOutputPort, never()).findDestinyRating(anyString());
    }
}