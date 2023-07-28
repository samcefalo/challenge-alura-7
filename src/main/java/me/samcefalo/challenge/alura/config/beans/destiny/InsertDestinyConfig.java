package me.samcefalo.challenge.alura.config.beans.destiny;

import me.samcefalo.challenge.alura.application.core.usecase.destiny.InsertDestinyUseCase;
import me.samcefalo.challenge.alura.application.ports.in.destiny.InsertDestinyInputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.CreateDestinyDescriptionOutputPort;
import me.samcefalo.challenge.alura.application.ports.out.destiny.InsertDestinyOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertDestinyConfig {

    @Bean
    public InsertDestinyInputPort insertDestinyInputPort(InsertDestinyOutputPort insertDestinyOutputPort, CreateDestinyDescriptionOutputPort createDestinyDescriptionOutputPort) {
        return new InsertDestinyUseCase(insertDestinyOutputPort, createDestinyDescriptionOutputPort);
    }

}
