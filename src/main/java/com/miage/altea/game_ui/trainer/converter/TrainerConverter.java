package com.miage.altea.game_ui.trainer.converter;

import com.miage.altea.game_ui.bo.PokemonWithLvl;
import com.miage.altea.game_ui.bo.TrainerWithPokemons;
import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.game_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.game_ui.trainer.bo.Pokemon;
import com.miage.altea.game_ui.trainer.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainerConverter {
    @Autowired
    private PokemonTypeService pokemonTypeService;

    public TrainerWithPokemons trainerToTrainerWithPokemons(Trainer trainer) {
        List<Integer> ids = trainer.getTeam().stream().map(Pokemon::getPokemonTypeId).collect(Collectors.toList());

        List<PokemonType> pokemonTypes = pokemonTypeService.listPokemonsTypes(ids);

        List<PokemonWithLvl> pokemonWithLvls = new ArrayList<>();

        trainer.getTeam().stream().forEach(pokemon -> {
            pokemonWithLvls.add(
                    new PokemonWithLvl(
                            pokemon.getLevel(),
                            pokemonTypes.stream()
                                    .filter(pokemonType -> pokemon.getPokemonTypeId() == pokemonType.getId())
                                    .findAny().get()
                    )
            );
        });

        return TrainerWithPokemons.builder()
                .trainer(trainer)
                .team(pokemonWithLvls)
                .build();
    }
}
