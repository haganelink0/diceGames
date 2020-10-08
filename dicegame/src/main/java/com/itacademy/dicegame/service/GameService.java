package com.itacademy.dicegame.service;


import org.springframework.stereotype.Service;

import com.itacademy.dicegame.dto.impl.GameResponseDto;
import com.itacademy.dicegame.dto.impl.UserResponseDto;



@Service
public interface GameService {
	
	void saveGame(GameResponseDto game);
	
	Iterable<GameResponseDto>findGamesByUser(UserResponseDto user);
	
	void deleteGameHistory(UserResponseDto user);
	
	


}
