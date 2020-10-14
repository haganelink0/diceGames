package com.itacademy.dicegame.service;


import com.itacademy.dicegame.dto.impl.UserResponseDto;

public interface UserService {
	
	UserResponseDto findUserById(Integer id);
	
	void saveUser(UserResponseDto user);
	
	Iterable<UserResponseDto> findAllUsers();

	
	

}
