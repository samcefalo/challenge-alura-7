package me.samcefalo.challenge.alura.adapters.out.destiny;

import me.samcefalo.challenge.alura.adapters.out.destiny.repository.DestinyRepository;
import me.samcefalo.challenge.alura.adapters.out.destiny.repository.entity.DestinyEntity;
import me.samcefalo.challenge.alura.adapters.out.destiny.repository.mapper.DestinyEntityMapper;
import me.samcefalo.challenge.alura.application.core.domain.Destiny;
import me.samcefalo.challenge.alura.application.ports.out.destiny.InsertDestinyOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertDestinyAdapter implements InsertDestinyOutputPort {

    private final DestinyRepository destinyRepository;
    private final DestinyEntityMapper DestinyEntityMapper;

    @Autowired
    public InsertDestinyAdapter(DestinyRepository destinyRepository, me.samcefalo.challenge.alura.adapters.out.destiny.repository.mapper.DestinyEntityMapper destinyEntityMapper) {
        this.destinyRepository = destinyRepository;
        DestinyEntityMapper = destinyEntityMapper;
    }

    @Override
    public void insert(Destiny destiny) {
        DestinyEntity destinyEntity = DestinyEntityMapper.toDestinyEntity(destiny);

        destinyRepository.save(destinyEntity);
    }
}
