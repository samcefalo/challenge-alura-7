package me.samcefalo.challenge.alura.config.beans.destiny;

import me.samcefalo.challenge.alura.application.core.usecase.destiny.UpdateDestinyPriceUseCase;
import me.samcefalo.challenge.alura.application.ports.in.destiny.UpdateDestinyPriceInputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.FindDestinyByIdOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.UpdateDestinyOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateDestinyPriceConfig {

    @Bean
    public UpdateDestinyPriceInputPort updateDestinyPriceInputPort(FindDestinyByIdOutputPort findDestinyByIdOutputPort, UpdateDestinyOutputPort updateDestinyOutputPort) {
        return new UpdateDestinyPriceUseCase(findDestinyByIdOutputPort, updateDestinyOutputPort);
    }

}
