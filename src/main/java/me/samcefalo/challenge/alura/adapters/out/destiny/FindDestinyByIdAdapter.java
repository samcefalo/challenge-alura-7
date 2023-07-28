package me.samcefalo.challenge.alura.adapters.out.destiny;

import me.samcefalo.challenge.alura.adapters.out.destiny.repository.DestinyRepository;
import me.samcefalo.challenge.alura.adapters.out.destiny.repository.mapper.DestinyEntityMapper;
import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.ports.out.destiny.FindDestinyByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindDestinyByIdAdapter implements FindDestinyByIdOutputPort {

    private final DestinyRepository destinyRepository;
    private final DestinyEntityMapper DestinyEntityMapper;

    @Autowired
    public FindDestinyByIdAdapter(DestinyRepository destinyRepository, DestinyEntityMapper destinyEntityMapper) {
        this.destinyRepository = destinyRepository;
        DestinyEntityMapper = destinyEntityMapper;
    }

    @Override
    public Optional<Destiny> findById(String id) {
        return destinyRepository.findById(id).map(DestinyEntityMapper::toDestiny);
    }

}
