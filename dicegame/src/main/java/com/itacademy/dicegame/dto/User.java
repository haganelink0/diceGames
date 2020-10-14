package com.itacademy.dicegame.dto;

import com.itacademy.dicegame.dto.impl.GameResponseDto;

public interface User {
	
	void insertNewGame(GameResponseDto game);
}