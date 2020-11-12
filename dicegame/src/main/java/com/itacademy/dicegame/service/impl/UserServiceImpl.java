package com.itacademy.dicegame.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.dicegame.dto.impl.UserResponseDto;
import com.itacademy.dicegame.repository.UserRepository;
import com.itacademy.dicegame.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;

	@Override
	public Optional<UserResponseDto> findUserById(Integer id) {
		return repository.findById(id);
		
	}

	@Override
	public void saveUser(UserResponseDto user) {
		repository.save(user);

	}


	@Override
	public Iterable<UserResponseDto> findAllUsers() {
		return repository.findAll();
	}

}
