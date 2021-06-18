package com.maplr.testhockeygame.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "PLAYER")
public class Player {

	@Id
	private long number;
	private String name;
	private String lastName;
	private boolean isCaptain;

	@ManyToOne
	private Team team;

	public Player(long number, String name, String lastName, boolean isCaptain) {
		this.number = number;
		this.name = name;
		this.lastName = lastName;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Player player = (Player) o;
		return number == player.number && isCaptain == player.isCaptain && Objects.equals(name, player.name) && Objects.equals(lastName, player.lastName) && Objects.equals(team, player.team);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, name, lastName, isCaptain, team);
	}

	@Override
	public String toString() {
		return "Player{" +
				"number=" + number +
				", name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", isCaptain=" + isCaptain +
				", team=" + team +
				'}';
	}
}
