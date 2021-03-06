package com.miage.altea.game_ui.pokemonTypes.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sprites {
    private String back_default;
    private String front_default;
}
