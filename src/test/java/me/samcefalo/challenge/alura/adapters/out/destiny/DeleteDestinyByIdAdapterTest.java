package me.samcefalo.challenge.alura.adapters.out.destiny;

import me.samcefalo.challenge.alura.adapters.out.destiny.repository.DestinyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class DeleteDestinyByIdAdapterTest {

    private DestinyRepository destinyRepository;
    private DeleteDestinyByIdAdapter deleteDestinyByIdAdapter;

    @BeforeEach
    void setup() {
        destinyRepository = mock(DestinyRepository.class);
        deleteDestinyByIdAdapter = new DeleteDestinyByIdAdapter(destinyRepository);
    }

    @Test
    public void should_delete_destiny_by_id() {
        String id = "1";

        doNothing().when(destinyRepository).deleteById(id);

        deleteDestinyByIdAdapter.deleteById(id);

        verify(destinyRepository, times(1)).deleteById(id);
    }
}