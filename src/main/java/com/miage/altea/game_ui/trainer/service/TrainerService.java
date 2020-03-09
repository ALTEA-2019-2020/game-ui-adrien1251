package com.miage.altea.game_ui.trainer.service;

import com.miage.altea.game_ui.bo.TrainerWithPokemons;
import com.miage.altea.game_ui.trainer.bo.Trainer;

import java.util.List;

public interface TrainerService {
    List<TrainerWithPokemons> getAllTrainers();
    List<TrainerWithPokemons> getAllTrainers(String actualTrainer);
    TrainerWithPokemons getTrainer(String name);
}
