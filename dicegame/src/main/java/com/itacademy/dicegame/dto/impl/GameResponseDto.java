package com.itacademy.dicegame.dto.impl;

import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itacademy.dicegame.dto.Game;

@Entity
@Table(name="games")
public class GameResponseDto implements Game {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="first_dice")
	private Integer firstDice;
	@Column(name="second_dice")
	private Integer secondDice;
	@Column(name="result")
	private Result result;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="user_id")
	@JsonIgnore
	private UserResponseDto user;
	@Transient
	private Random rdm = new Random();
	
	public GameResponseDto() {
		
	}
	
	public GameResponseDto(Integer id, Integer firstDice, Integer secondDice) {
		super();
		this.id = id;
		this.firstDice = firstDice;
		this.secondDice = secondDice;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFirstDice() {
		return firstDice;
	}

	public void setFirstDice() {
		this.firstDice = rdm.nextInt(6)+1;
	}

	public Integer getSecondDice() {
		return secondDice;
	}

	public void setSecondDice() {
		this.secondDice = rdm.nextInt(6)+1;
	}

	public Result getResult() {
		return result;
	}

	public void setResult() {
		if (this.firstDice+this.secondDice == 7) {
			this.result = Result.WIN;
		} else {
			this.result = Result.LOSE;
		}
	}
	
	public UserResponseDto getUser() {
		return user;
	}

	public void setUser(UserResponseDto user) {
		this.user = user;
	}

	//makes sure the game is properly created and gives 0-1 response to account for winrate
	@Override
	public Integer resolveGame() {
		Integer temporalResult = 0;
		if (this.firstDice < 0 || this.firstDice > 6) {
			setFirstDice();
		}
		if (this.secondDice < 0 || this.secondDice > 6) {
			setSecondDice();
		}
		setResult();
		if (this.result.equals(Result.WIN)) {
			temporalResult = 1;
		}
		return temporalResult;
	}
}
