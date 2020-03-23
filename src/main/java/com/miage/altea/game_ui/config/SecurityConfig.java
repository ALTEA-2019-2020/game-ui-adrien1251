package com.miage.altea.game_ui.config;

import com.miage.altea.game_ui.trainer.bo.Trainer;
import com.miage.altea.game_ui.trainer.service.TrainerService;
import com.miage.altea.game_ui.trainer.service.TrainerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Optional;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private TrainerService trainerService;

    @Autowired
    void setTrainerService(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return userName -> Optional.ofNullable(trainerService.getTrainer(userName))
                .map((trainer) ->
                    User.withUsername(trainer.getTrainer().getName())
                            .password(trainer.getTrainer().getPassword())
                            .roles("USER")
                            .build()
                ).orElseThrow(() -> new BadCredentialsException("No such user"));
    }

}