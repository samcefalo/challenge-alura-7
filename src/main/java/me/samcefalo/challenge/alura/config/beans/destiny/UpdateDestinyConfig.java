package me.samcefalo.challenge.alura.config.beans.destiny;

import me.samcefalo.challenge.alura.application.core.usecase.destiny.UpdateDestinyUseCase;
import me.samcefalo.challenge.alura.application.ports.in.destiny.UpdateDestinyInputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.UpdateDestinyOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateDestinyConfig {

    @Bean
    public UpdateDestinyInputPort updateDestinyInputPort(UpdateDestinyOutputPort updateDestinyOutputPort) {
        return new UpdateDestinyUseCase(updateDestinyOutputPort);
    }

}
