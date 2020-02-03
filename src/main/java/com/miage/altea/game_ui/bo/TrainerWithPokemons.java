package com.miage.altea.game_ui.bo;

import com.miage.altea.game_ui.trainer.bo.Trainer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainerWithPokemons {
    private Trainer trainer;

    private List<PokemonWithLvl> team;
}
