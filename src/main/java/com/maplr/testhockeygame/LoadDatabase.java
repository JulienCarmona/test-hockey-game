package com.maplr.testhockeygame;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;
import com.maplr.testhockeygame.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class LoadDatabase {

    @Bean
    public CommandLineRunner teamInitializer(TeamRepository teamRepository) {
        return args -> teamRepository.saveAll(Arrays.asList(
                new Team("Dominique Ducharme", 2019, initListPlayers()),
                new Team("Dominique Ducharme", 2020, initListPlayers())
            ));
    }

    private List<Player> initListPlayers() {
        return Arrays.asList(
                new Player(31, "Carey", "Price", "goaltender", false),
                new Player(14, "Nick", "Suzuki", "foward", false),
                new Player(15, "Jesperi", "Kotkaniemi", "foward", false),
                new Player(71, "Jake", "Evans", "foward", false),
                new Player(27, "Alexander", "Romanov", "defenseman", false),
                new Player(6, "Shea", "Weber", "defenseman", true)
        );
    }

}
