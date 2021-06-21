package com.maplr.testhockeygame.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TEAM")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String coach;
	private long year;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "teamId")
	private List<Player> players;

	public Team() {}

	public Team(String coach, long year, List<Player> players) {
		this.coach = coach;
		this.year = year;
		this.players = players;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	public List <Player> getPlayers() {
		return players;
	}

	public void setPlayers(List <Player> players) {
		this.players = players;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Team team = (Team) o;
		return id == team.id && year == team.year && Objects.equals(coach, team.coach) && Objects.equals(players, team.players);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, coach, year, players);
	}

	@Override
	public String toString() {
		return "Team{" +
				"id=" + id +
				", coach='" + coach + '\'' +
				", year=" + year +
				", players=" + players +
				'}';
	}
}
