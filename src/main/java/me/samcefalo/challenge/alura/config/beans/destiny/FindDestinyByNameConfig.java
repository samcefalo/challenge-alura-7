package me.samcefalo.challenge.alura.config.beans.destiny;

import me.samcefalo.challenge.alura.application.core.usecase.destiny.FindDestinyByNameUseCase;
import me.samcefalo.challenge.alura.application.ports.in.destiny.FindDestinyByNameInputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.FindDestinyByNameOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.rating.FindDestinyRatingOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindDestinyByNameConfig {

    @Bean
    public FindDestinyByNameInputPort findDestinyByNameInputPort(FindDestinyByNameOutputPort findDestinyByNameOutputPort, FindDestinyRatingOutputPort findDestinyRatingOutputPort) {
        return new FindDestinyByNameUseCase(findDestinyByNameOutputPort, findDestinyRatingOutputPort);
    }

}
