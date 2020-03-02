package com.miage.altea.game_ui.controller;

import com.miage.altea.game_ui.trainer.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping(value = "/profil")
public class ProfilController {

    private TrainerService trainerService;

    @GetMapping(value = "/")
    public ModelAndView profil(){
        var modelAndView = new ModelAndView("profil");

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        modelAndView.addObject("trainer", trainerService.getTrainer(principal.getUsername()));
        modelAndView.addObject("allTrainer", trainerService.getAllTrainers(principal.getUsername()));
        return modelAndView;
    }

    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }
}