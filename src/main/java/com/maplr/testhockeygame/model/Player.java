package com.maplr.testhockeygame.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PLAYER")
public class Player {

	@Id
	private long number;
	private String name;
	private String lastName;
	private String position;
	private boolean isCaptain;

	@ManyToMany(mappedBy = "players")
	private List<Team> teams;

	public Player() {}

	public Player(long number, String name, String lastName, String position, boolean isCaptain) {
		this.number = number;
		this.name = name;
		this.lastName = lastName;
		this.position = position;
		this.isCaptain = isCaptain;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isCaptain() {
		return isCaptain;
	}

	public void setCaptain(boolean captain) {
		isCaptain = captain;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public List<Team> getTeam() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Player player = (Player) o;
		return number == player.number && isCaptain == player.isCaptain && Objects.equals(name, player.name) && Objects.equals(lastName, player.lastName) && Objects.equals(position, player.position) && Objects.equals(teams, player.teams);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, name, lastName, position, isCaptain, teams);
	}

	@Override
	public String toString() {
		return "Player{" +
				"number=" + number +
				", name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", position='" + position + '\'' +
				", isCaptain=" + isCaptain +
				", teams=" + teams +
				'}';
	}
}
