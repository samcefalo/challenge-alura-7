package me.samcefalo.challenge.alura.application.core.usecase.destiny;


import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.core.domain.DestinyMother;
import me.samcefalo.challenge.alura.application.ports.out.destiny.CreateDestinyDescriptionOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.InsertDestinyOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class InsertDestinyUseCaseTest {

    private InsertDestinyOutputPort insertDestinyOutputPort;
    private CreateDestinyDescriptionOutputPort createDestinyDescriptionOutputPort;
    private InsertDestinyUseCase insertDestinyUseCase;

    @BeforeEach
    void setup() {
        insertDestinyOutputPort = mock(InsertDestinyOutputPort.class);
        createDestinyDescriptionOutputPort = mock(CreateDestinyDescriptionOutputPort.class);
        insertDestinyUseCase = new InsertDestinyUseCase(insertDestinyOutputPort, createDestinyDescriptionOutputPort);
    }

    @Test
    public void should_insert() {
        Destiny destiny = DestinyMother.createDestiny("test");

        when(createDestinyDescriptionOutputPort.createDescription(destiny)).thenReturn("test");
        doNothing().when(insertDestinyOutputPort).insert(destiny);

        insertDestinyUseCase.insert(destiny);

        verify(insertDestinyOutputPort, times(1)).insert(destiny);
        verify(createDestinyDescriptionOutputPort, never()).createDescription(destiny);
    }

    @Test
    public void should_insert_with_null_description() {
        String expectedDescription = "test";
        Destiny destiny = DestinyMother.createDestiny("test");
        destiny.setDescription(null);

        when(createDestinyDescriptionOutputPort.createDescription(destiny)).thenReturn(expectedDescription);
        doNothing().when(insertDestinyOutputPort).insert(destiny);

        insertDestinyUseCase.insert(destiny);

        assertEquals(expectedDescription, destiny.getDescription());
        verify(insertDestinyOutputPort, times(1)).insert(destiny);
        verify(createDestinyDescriptionOutputPort, times(1)).createDescription(destiny);
    }
}