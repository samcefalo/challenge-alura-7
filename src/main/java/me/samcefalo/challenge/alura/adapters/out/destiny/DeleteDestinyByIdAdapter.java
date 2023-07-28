package me.samcefalo.challenge.alura.adapters.out.destiny;

import me.samcefalo.challenge.alura.adapters.out.destiny.repository.DestinyRepository;
import me.samcefalo.challenge.alura.application.ports.out.destiny.DeleteDestinyByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteDestinyByIdAdapter implements DeleteDestinyByIdOutputPort {

    private final DestinyRepository destinyRepository;

    @Autowired
    public DeleteDestinyByIdAdapter(DestinyRepository destinyRepository) {
        this.destinyRepository = destinyRepository;
    }

    @Override
    public void deleteById(String id) {
        destinyRepository.deleteById(id);
    }
}
