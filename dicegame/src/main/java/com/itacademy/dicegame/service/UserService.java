package com.itacademy.dicegame.service;

import java.util.List;

import com.itacademy.dicegame.dto.impl.UserResponseDto;

public interface UserService {
	
	UserResponseDto findUserById(Integer id);
	
	void saveUser(UserResponseDto user);
	
	Iterable<UserResponseDto> findAllUsers();
	
	UserResponseDto findUserByWinrate(Double winrate);
	
	

}