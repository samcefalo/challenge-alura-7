package me.samcefalo.challenge.alura.adapters.out.destiny.ia.gpt.client.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GPTMessage {

    private String role;
    private String content;

}
