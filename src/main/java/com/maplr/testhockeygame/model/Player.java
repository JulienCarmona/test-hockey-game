package com.maplr.testhockeygame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Objects;

@Entity
@Table(name = "PLAYER")
@SequenceGenerator(name = "SEQ_GEN_PLAYER", sequenceName ="SEQ_PLAYER", allocationSize = 1)
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_PLAYER")
	private long playerId;
	private long number;
	private String name;
	private String lastname;
	private String position;
	private boolean isCaptain;

	@ManyToOne
	@JoinColumn(name = "teamId")
	private Team team;

	public Player() {}

	public Player(long number, String name, String lastname, String position, boolean isCaptain) {
		this.number = number;
		this.name = name;
		this.lastname = lastname;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	@JsonIgnore
	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	@JsonIgnore
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Player player = (Player) o;
		return number == player.number && isCaptain == player.isCaptain && Objects.equals(name, player.name) && Objects.equals(lastname, player.lastname) && Objects.equals(position, player.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, name, lastname, position, isCaptain);
	}

	@Override
	public String toString() {
		return "Player{" +
				"number=" + number +
				", name='" + name + '\'' +
				", lastname='" + lastname + '\'' +
				", position='" + position + '\'' +
				", isCaptain=" + isCaptain +
				'}';
	}
}
