package com.maplr.testhockeygame;

import com.maplr.testhockeygame.model.Player;
import com.maplr.testhockeygame.model.Team;
import com.maplr.testhockeygame.repository.PlayerRepository;
import com.maplr.testhockeygame.repository.TeamRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootApplication
public class TestHockeyGameApplication {


	public static void main(String[] args) {
		SpringApplication.run(TestHockeyGameApplication.class, args);
	}

	@Bean
	ApplicationRunner playerInitializer(PlayerRepository playerRepository) {
		return args -> playerRepository.saveAll(Arrays.asList(
				new Player(31, "Carey", "Price", "goaltender", false),
				new Player(14, "Nick", "Suzuki", "foward", false),
				new Player(15, "Jesperi", "Kotkaniemi", "foward", false),
				new Player(71, "Jake", "Evans", "foward", false),
				new Player(27, "Alexander", "Romanov", "defenseman", false),
				new Player(6, "Shea", "Weber", "defenseman", true)
		));
	}

	@Bean
	public ApplicationRunner teamInitializer(TeamRepository teamRepository, PlayerRepository playerRepository) {
		List<Player> players = StreamSupport
				.stream(playerRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return args -> teamRepository.saveAll(Arrays.asList(
				new Team("Dominique Ducharme", 2019, players),
				new Team("Dominique Ducharme", 2020, players)
		));
	}
}
