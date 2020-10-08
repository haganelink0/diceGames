package com.itacademy.dicegame.controller;

import org.springframework.http.ResponseEntity;


import com.itacademy.dicegame.dto.impl.GameResponseDto;

public interface IGameController {
	
	void playGame(Integer id, GameResponseDto game);
	
	void deleteGameHistory(Integer id);
	
	ResponseEntity<Iterable<GameResponseDto>> seeGameHistory(Integer id);

}
