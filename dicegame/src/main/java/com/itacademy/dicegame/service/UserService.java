package com.itacademy.dicegame.service;


import java.util.Optional;

import com.itacademy.dicegame.dto.impl.UserResponseDto;

public interface UserService {
	
	Optional<UserResponseDto> findUserById(Integer id);
	
	void saveUser(UserResponseDto user);
	
	Iterable<UserResponseDto> findAllUsers();

	
	

}
