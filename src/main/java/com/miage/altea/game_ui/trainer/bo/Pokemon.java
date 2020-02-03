package com.miage.altea.game_ui.trainer.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pokemon {
    private int pokemonTypeId;

    private int level;
}
