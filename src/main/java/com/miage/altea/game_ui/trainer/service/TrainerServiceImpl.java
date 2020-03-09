package com.miage.altea.game_ui.trainer.service;

import com.miage.altea.game_ui.bo.PokemonWithLvl;
import com.miage.altea.game_ui.bo.TrainerWithPokemons;
import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.game_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.game_ui.trainer.bo.Pokemon;
import com.miage.altea.game_ui.trainer.bo.Trainer;
import com.miage.altea.game_ui.trainer.converter.TrainerConverter;
import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerServiceImpl implements TrainerService {
    private final String TRAINER_PATH = "/trainers/";

    private RestTemplate restTemplate;

    private String trainerServiceUrl;

    private PokemonTypeService pokemonTypeService;

    @Autowired
    private TrainerConverter trainerConverter;

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    void setPokemonTypeService(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

    @Value("${trainers.service.url}")
    void setTrainerServiceUrl(String trainerServiceUrl) {
        this.trainerServiceUrl = trainerServiceUrl;
    }

    @Override
    public List<Trainer> getAllTrainers() {
        Trainer[] trainers = restTemplate.getForObject(trainerServiceUrl + TRAINER_PATH, Trainer[].class);
        return Arrays.asList(trainers);
    }

    @Override
    public List<TrainerWithPokemons> getAllTrainers(String actualTrainer) {
        Trainer[] trainers = restTemplate.getForObject(trainerServiceUrl + TRAINER_PATH, Trainer[].class);

        return Arrays.stream(trainers)
                .filter(trainer -> !trainer.getName().equals(actualTrainer))
                .map(trainerConverter::trainerToTrainerWithPokemons)
                .collect(Collectors.toList());
    }

    @Override
    public TrainerWithPokemons getTrainer(String name) {
        return trainerConverter.trainerToTrainerWithPokemons(
                restTemplate.getForObject(trainerServiceUrl + TRAINER_PATH + name, Trainer.class)
        );
    }
}
