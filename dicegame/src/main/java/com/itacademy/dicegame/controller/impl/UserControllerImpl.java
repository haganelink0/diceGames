package com.itacademy.dicegame.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itacademy.dicegame.controller.IUserController;
import com.itacademy.dicegame.dto.impl.UserResponseDto;
import com.itacademy.dicegame.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/Api/v1")
@CrossOrigin(origins = "http://localhost:8080", 
			 methods= {RequestMethod.GET, RequestMethod.POST})
public class UserControllerImpl implements IUserController {
	
	@Autowired
	UserServiceImpl service;

	@Override
	@PostMapping(path="/players", consumes="application/json")
	public void saveUser(UserResponseDto user) {
		service.saveUser(user);

	}

	@Override
	@PutMapping(path="/players/{id}")
	public void changeName(@PathVariable Integer id,@RequestBody String newName) {
		UserResponseDto bddUser = service.findUserById(id);
		bddUser.setName(newName);
		service.saveUser(bddUser);

	}

	@Override
	@GetMapping(path="/players/")
	public ResponseEntity<Iterable<UserResponseDto>> seeAllUsers() {
		return new ResponseEntity<>(service.findAllUsers(), HttpStatus.OK);
	}

	@Override
	@GetMapping(path="/players/ranking/")
	public Double getAverageWinrate() {
		Iterable<UserResponseDto> users = service.findAllUsers();
		double total = 0;
		double amount = 0;
		for (UserResponseDto user : users) {
			total += user.getWinPercen();
			amount++;
		}
		return total/amount;
	}

	@Override
	@GetMapping(path="/players/ranking/loser")
	public ResponseEntity<UserResponseDto> getWorsePlayer() {
		Iterable<UserResponseDto> users = service.findAllUsers();
		UserResponseDto worsePlayer = new UserResponseDto();
		worsePlayer.setWinPercen();
		for (UserResponseDto user: users) {
			if (user.getWinPercen() < worsePlayer.getWinPercen()) {
				worsePlayer = user;
			}
		}
		return new ResponseEntity<>(worsePlayer, HttpStatus.OK);
	}

	@Override
	@GetMapping(path="/players/ranking/winner")
	public ResponseEntity<UserResponseDto> getBestPlayer() {
		Iterable<UserResponseDto> users = service.findAllUsers();
		UserResponseDto bestPlayer = new UserResponseDto();
		bestPlayer.setWinPercen();
		for (UserResponseDto user: users) {
			if (user.getWinPercen() > bestPlayer.getWinPercen()) {
				bestPlayer = user;
			}
		}
		return new ResponseEntity<>(bestPlayer, HttpStatus.OK);
	}

}
