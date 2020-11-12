package com.itacademy.dicegame.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.itacademy.dicegame.dto.impl.UserResponseDto;

public interface IUserController {
	
	void saveUser(UserResponseDto user);
	
	void changeName(Integer id, String newName);
	
	ResponseEntity<List<UserResponseDto>> seeAllUsers();
	
	Double getAverageWinrate();
	
	ResponseEntity<UserResponseDto> getWorsePlayer();
	
	ResponseEntity<UserResponseDto> getBestPlayer();

}
