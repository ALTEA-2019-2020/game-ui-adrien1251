package com.miage.altea.game_ui.controller;

import com.miage.altea.game_ui.trainer.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/trainers")
public class TrainerController {

    private TrainerService trainerService;

    @GetMapping(value = "/")
    public ModelAndView trainers(){
        var modelAndView = new ModelAndView("trainers");
        modelAndView.addObject("allTrainer", trainerService.getAllTrainers());
        return modelAndView;
    }

    @GetMapping(value = "/{name}")
    public ModelAndView trainerName(@PathVariable String name){
        var modelAndView = new ModelAndView("trainerDetail");
        modelAndView.addObject("trainerDetail", trainerService.getTrainer(name));
        return modelAndView;
    }

    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }
}