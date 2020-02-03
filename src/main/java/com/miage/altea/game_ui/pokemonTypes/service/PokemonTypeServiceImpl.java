package com.miage.altea.game_ui.pokemonTypes.service;

import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {
    private final String POKEMON_TYPE_PATH = "/pokemon-types/";

    private RestTemplate restTemplate;


    private String pokemonServiceUrl;

    @Override
    public List<PokemonType> listPokemonsTypes() {
        PokemonType[] pokemonTypes = restTemplate.getForObject(pokemonServiceUrl + POKEMON_TYPE_PATH, PokemonType[].class);
        return Arrays.asList(pokemonTypes);
    }

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }

}
