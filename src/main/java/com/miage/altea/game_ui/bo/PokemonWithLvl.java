package com.miage.altea.game_ui.bo;

import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.game_ui.pokemonTypes.bo.Sprites;
import com.miage.altea.game_ui.pokemonTypes.bo.Stats;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonWithLvl {
    private int id;
    private int baseExperience;
    private int height;
    private String name;
    private Sprites sprites;
    private Stats stats;
    private int weight;
    private List<String> types;
    private int level;

    public PokemonWithLvl(int level, PokemonType pokemonType) {
        this.level = level;
        this.id = pokemonType.getId();
        this.baseExperience = pokemonType.getBaseExperience();
        this.height = pokemonType.getHeight();
        this.name = pokemonType.getName();
        this.sprites = pokemonType.getSprites();
        this.stats = pokemonType.getStats();
        this.weight = pokemonType.getWeight();
        this.types = pokemonType.getTypes();
    }
}
