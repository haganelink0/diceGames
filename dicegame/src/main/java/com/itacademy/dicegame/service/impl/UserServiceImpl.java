package com.itacademy.dicegame.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.itacademy.dicegame.dto.impl.UserResponseDto;
import com.itacademy.dicegame.repository.UserRepository;
import com.itacademy.dicegame.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;

	@Override
	public UserResponseDto findUserById(Integer id) {
		Optional<UserResponseDto> user = repository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	@Override
	public void saveUser(UserResponseDto user) {
		repository.save(user);

	}


	@Override
	public Iterable<UserResponseDto> findAllUsers() {
		return repository.findAll();
	}

	@Override
	public UserResponseDto findUserByWinrate(Double winrate) {
		return repository.findByWinrate(winrate);
	}

}
