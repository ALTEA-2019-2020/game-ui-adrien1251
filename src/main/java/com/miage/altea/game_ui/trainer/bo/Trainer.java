package com.miage.altea.game_ui.trainer.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Trainer {
    private String name;

    private String password;

    private List<Pokemon> team;
}
