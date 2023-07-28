package me.samcefalo.challenge.alura.config.beans.destiny;

import me.samcefalo.challenge.alura.application.core.usecase.destiny.DeleteDestinyByIdUseCase;
import me.samcefalo.challenge.alura.application.ports.in.destiny.DeleteDestinyByIdInputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.DeleteDestinyByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteDestinyByIdConfig {

    @Bean
    public DeleteDestinyByIdInputPort deleteDestinyByIdInputPort(DeleteDestinyByIdOutputPort deleteDestinyByIdOutputPort) {
        return new DeleteDestinyByIdUseCase(deleteDestinyByIdOutputPort);
    }

}
