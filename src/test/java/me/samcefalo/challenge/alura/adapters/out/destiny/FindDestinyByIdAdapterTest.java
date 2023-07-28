package me.samcefalo.challenge.alura.adapters.out.destiny;

import me.samcefalo.challenge.alura.adapters.out.destiny.repository.DestinyRepository;
import me.samcefalo.challenge.alura.adapters.out.destiny.repository.entity.DestinyEntity;
import me.samcefalo.challenge.alura.adapters.out.destiny.repository.entity.DestinyEntityMother;
import me.samcefalo.challenge.alura.adapters.out.destiny.repository.mapper.DestinyEntityMapper;
import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.core.domain.DestinyMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class FindDestinyByIdAdapterTest {

    private DestinyRepository destinyRepository;
    private DestinyEntityMapper destinyEntityMapper;
    private FindDestinyByIdAdapter findDestinyByIdAdapter;

    @BeforeEach
    void setup() {
        destinyEntityMapper = mock(DestinyEntityMapper.class);
        destinyRepository = mock(DestinyRepository.class);
        findDestinyByIdAdapter = new FindDestinyByIdAdapter(destinyRepository, destinyEntityMapper);
    }

    @Test
    public void should_find_by_id() {
        String id = "1";
        Destiny expected = DestinyMother.createDestiny("test");
        DestinyEntity destinyEntity = DestinyEntityMother.createDestinyEntity("test");

        when(destinyRepository.findById(id)).thenReturn(Optional.of(destinyEntity));
        when(destinyEntityMapper.toDestiny(destinyEntity)).thenReturn(expected);

        Optional<Destiny> result = findDestinyByIdAdapter.findById(id);

        assertTrue(result.isPresent());
        assertEquals(expected, result.get());
        verify(destinyRepository, times(1)).findById(id);
        verify(destinyEntityMapper, times(1)).toDestiny(destinyEntity);
    }
}