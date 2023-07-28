package me.samcefalo.challenge.alura.adapters.out.destiny;

import me.samcefalo.challenge.alura.adapters.out.destiny.repository.DestinyRepository;
import me.samcefalo.challenge.alura.adapters.out.destiny.repository.mapper.DestinyEntityMapper;
import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.ports.out.destiny.FindDestinyByNameOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindDestinyByNameAdapter implements FindDestinyByNameOutputPort {

    private final DestinyRepository destinyRepository;
    private final DestinyEntityMapper DestinyEntityMapper;

    @Autowired
    public FindDestinyByNameAdapter(DestinyRepository destinyRepository, me.samcefalo.challenge.alura.adapters.out.destiny.repository.mapper.DestinyEntityMapper destinyEntityMapper) {
        this.destinyRepository = destinyRepository;
        DestinyEntityMapper = destinyEntityMapper;
    }

    @Override
    public List<Destiny> findByName(String name) {
        return destinyRepository.findAllByNameContaining(name)
                .stream().map(DestinyEntityMapper::toDestiny)
                .toList();
    }
}
