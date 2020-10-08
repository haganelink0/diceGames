package com.itacademy.dicegame.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itacademy.dicegame.controller.IUserController;
import com.itacademy.dicegame.dto.impl.UserResponseDto;

@RestController
@RequestMapping("/Api/v1")
@CrossOrigin(origins = "http://localhost:8080", 
			 methods= {RequestMethod.GET, RequestMethod.POST})
public class UserControllerImpl implements IUserController {

	@Override
	public void saveUser(UserResponseDto user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeName(UserResponseDto user, String newName) {
		// TODO Auto-generated method stub

	}

	@Override
	public ResponseEntity<Iterable<UserResponseDto>> seeAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getAverageWinrate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UserResponseDto> getWorsePlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UserResponseDto> getBestPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

}
