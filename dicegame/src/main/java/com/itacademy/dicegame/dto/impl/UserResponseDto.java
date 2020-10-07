package com.itacademy.dicegame.dto.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itacademy.dicegame.dto.Game;
import com.itacademy.dicegame.dto.User;

public class UserResponseDto implements User  {
	
	private Integer id;
	private String name;
	private String registrationDate;
	private List<Game> gameHistory;
	private double winPercen;
	
	public UserResponseDto() {
		super();
	}

	public UserResponseDto(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		this.registrationDate = formatter.format(date);
		this.gameHistory = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		this.registrationDate = formatter.format(date);
	}

	public List<Game> getGameHistory() {
		return gameHistory;
	}

	public void setGameHistory(List<Game> gameHistory) {
		this.gameHistory = gameHistory;
	}

	public double getWinPercen() {
		return winPercen;
	}

	public void setWinPercen() {
		double result = gameHistory.size();
		double gamesWon = 0;
		for(Game game: gameHistory) {
			gamesWon += game.resolveGame();
		}
		this.winPercen = gamesWon/result*100;
	}
	
	
	

}
