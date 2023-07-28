package me.samcefalo.challenge.alura.adapters.out.destiny;

import me.samcefalo.challenge.alura.adapters.out.destiny.ia.FindDestinyDescriptionWithIA;
import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.core.domain.DestinyMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreateDestinyDescriptionAdapterTest {

    private FindDestinyDescriptionWithIA findDestinyDescriptionWithIA;
    private CreateDestinyDescriptionAdapter createDestinyDescriptionAdapter;

    @BeforeEach
    void setUp() {
        findDestinyDescriptionWithIA = mock(FindDestinyDescriptionWithIA.class);
        createDestinyDescriptionAdapter = new CreateDestinyDescriptionAdapter(findDestinyDescriptionWithIA);
    }

    @Test
    public void should_create_destiny_description() {
        String expected = "test";
        Destiny destiny = DestinyMother.createDestiny("test");

        when(findDestinyDescriptionWithIA.findDescription(destiny.getName())).thenReturn(expected);

        String result = createDestinyDescriptionAdapter.createDescription(destiny);

        assertNotNull(result);
        assertEquals(expected, result);
    }

}