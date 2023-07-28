package me.samcefalo.challenge.alura.adapters.out.destiny;

import me.samcefalo.challenge.alura.adapters.out.destiny.repository.DestinyRepository;
import me.samcefalo.challenge.alura.adapters.out.destiny.repository.entity.DestinyEntity;
import me.samcefalo.challenge.alura.adapters.out.destiny.repository.entity.DestinyEntityMother;
import me.samcefalo.challenge.alura.adapters.out.destiny.repository.mapper.DestinyEntityMapper;
import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.core.domain.DestinyMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class UpdateDestinyAdapterTest {

    private DestinyRepository destinyRepository;
    private DestinyEntityMapper destinyEntityMapper;
    private UpdateDestinyAdapter updateDestinyAdapter;

    @BeforeEach
    void setup() {
        destinyEntityMapper = mock(DestinyEntityMapper.class);
        destinyRepository = mock(DestinyRepository.class);
        updateDestinyAdapter = new UpdateDestinyAdapter(destinyRepository, destinyEntityMapper);
    }

    @Test
    public void should_update() {
        Destiny destiny = DestinyMother.createDestiny("test");
        DestinyEntity expected = DestinyEntityMother.createDestinyEntity("test");

        when(destinyEntityMapper.toDestinyEntity(destiny)).thenReturn(expected);
        when(destinyRepository.save(expected)).thenReturn(expected);

        updateDestinyAdapter.update(destiny);

        verify(destinyRepository, times(1)).save(expected);
        verify(destinyEntityMapper, times(1)).toDestinyEntity(destiny);
    }
}