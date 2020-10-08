package com.itacademy.dicegame.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itacademy.dicegame.controller.IGameController;
import com.itacademy.dicegame.dto.impl.GameResponseDto;
import com.itacademy.dicegame.dto.impl.UserResponseDto;
import com.itacademy.dicegame.service.impl.GameServiceImpl;
import com.itacademy.dicegame.service.impl.UserServiceImpl;

@RestController
public class GameControllerImpl implements IGameController {

	@Autowired
	GameServiceImpl gameService;
	
	@Autowired
	UserServiceImpl userService;
	
	@Override
	@PostMapping(path="/players/{id}/games/", consumes="application/json")
	public void playGame(@PathVariable Integer id, @RequestBody GameResponseDto game) {
		UserResponseDto tempUser = userService.findUserById(id);
		game.setUser(tempUser);
		gameService.saveGame(game);

	}

	@Override
	@DeleteMapping(path="players/{id}/games")
	public void deleteGameHistory(@PathVariable Integer id) {
		UserResponseDto user = userService.findUserById(id);
		gameService.deleteGameHistory(user);

	}

	@Override
	@GetMapping(path="players/{id}/games")
	public ResponseEntity<Iterable<GameResponseDto>> seeGameHistory(@PathVariable Integer id) {
		UserResponseDto user = userService.findUserById(id);
		Iterable<GameResponseDto> gameHistory = gameService.findGamesByUser(user);
		return new ResponseEntity<>(gameHistory, HttpStatus.OK);
	}

}
