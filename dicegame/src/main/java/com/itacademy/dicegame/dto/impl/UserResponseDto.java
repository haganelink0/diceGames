package com.itacademy.dicegame.dto.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.itacademy.dicegame.dto.Game;
import com.itacademy.dicegame.dto.User;

@Entity
@Table(name="user")
public class UserResponseDto implements User  {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="registration_date")
	private String registrationDate;
	@Column(name="game_history")
	@OneToMany(mappedBy="user", cascade= {
			CascadeType.ALL	})
	private List<GameResponseDto> gameHistory;
	@Column(name="win_percen")
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

	public List<GameResponseDto> getGameHistory() {
		return gameHistory;
	}

	public void setGameHistory(List<GameResponseDto> gameHistory) {
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

	@Override
	public void insertNewGame(GameResponseDto game) {
		this.gameHistory.add(game);
		setWinPercen();
		
	}


	
	
	

}
