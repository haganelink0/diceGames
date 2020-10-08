package com.itacademy.dicegame.controller;

import org.springframework.http.ResponseEntity;

import com.itacademy.dicegame.dto.impl.UserResponseDto;

public interface IUserController {
	
	void saveUser(UserResponseDto user);
	
	void changeName(UserResponseDto user, String newName);
	
	ResponseEntity<Iterable<UserResponseDto>> seeAllUsers();
	
	Double getAverageWinrate();
	
	ResponseEntity<UserResponseDto> getWorsePlayer();
	
	ResponseEntity<UserResponseDto> getBestPlayer();

}
