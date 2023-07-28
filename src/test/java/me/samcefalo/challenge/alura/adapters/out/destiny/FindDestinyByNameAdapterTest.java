package me.samcefalo.challenge.alura.adapters.out.destiny;

import me.samcefalo.challenge.alura.adapters.out.destiny.repository.DestinyRepository;
import me.samcefalo.challenge.alura.adapters.out.destiny.repository.entity.DestinyEntity;
import me.samcefalo.challenge.alura.adapters.out.destiny.repository.entity.DestinyEntityMother;
import me.samcefalo.challenge.alura.adapters.out.destiny.repository.mapper.DestinyEntityMapper;
import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.core.domain.DestinyMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FindDestinyByNameAdapterTest {

    private DestinyRepository destinyRepository;
    private DestinyEntityMapper destinyEntityMapper;
    private FindDestinyByNameAdapter findDestinyByNameAdapter;

    @BeforeEach
    void setup() {
        destinyEntityMapper = mock(DestinyEntityMapper.class);
        destinyRepository = mock(DestinyRepository.class);
        findDestinyByNameAdapter = new FindDestinyByNameAdapter(destinyRepository, destinyEntityMapper);
    }

    @Test
    public void should_find_by_name() {
        String name = "1";
        Destiny destiny = DestinyMother.createDestiny("test");
        List<DestinyEntity> expected = List.of(DestinyEntityMother.createDestinyEntity("test"),
                DestinyEntityMother.createDestinyEntity("test2"));

        when(destinyRepository.findAllByNameContaining(name)).thenReturn(expected);
        when(destinyEntityMapper.toDestiny(any(DestinyEntity.class))).thenReturn(destiny);

        List<Destiny> result = findDestinyByNameAdapter.findByName(name);

        assertEquals(expected.size(), result.size());
        verify(destinyRepository, times(1)).findAllByNameContaining(name);
        verify(destinyEntityMapper, times(expected.size())).toDestiny(any(DestinyEntity.class));
    }
}