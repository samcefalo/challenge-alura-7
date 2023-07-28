package me.samcefalo.challenge.alura.config.beans.destiny;

import me.samcefalo.challenge.alura.application.core.usecase.destiny.FindDestinyByIdUseCase;
import me.samcefalo.challenge.alura.application.ports.in.destiny.FindDestinyByIdInputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.FindDestinyByIdOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.rating.FindDestinyRatingOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindDestinyByIdConfig {

    @Bean
    public FindDestinyByIdInputPort findDestinyByIdInputPort(FindDestinyByIdOutputPort findDestinyByIdOutputPort, FindDestinyRatingOutputPort findDestinyRatingOutputPort) {
        return new FindDestinyByIdUseCase(findDestinyByIdOutputPort, findDestinyRatingOutputPort);
    }

}
