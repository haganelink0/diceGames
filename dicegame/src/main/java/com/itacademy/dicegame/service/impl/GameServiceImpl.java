package com.itacademy.dicegame.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.dicegame.dto.impl.GameResponseDto;
import com.itacademy.dicegame.dto.impl.UserResponseDto;
import com.itacademy.dicegame.repository.GameRepository;
import com.itacademy.dicegame.service.GameService;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	GameRepository repository;

	@Override
	public void saveGame(GameResponseDto game) {
		repository.save(game);

	}

	@Override
	public Iterable<GameResponseDto> findGamesByUser(UserResponseDto user) {
		 return repository.findByUser(user);

	}

	@Override
	public void deleteGameHistory(UserResponseDto user) {
		Iterable<GameResponseDto> games = repository.findByUser(user);
		repository.deleteAll(games);
		
	}

}
