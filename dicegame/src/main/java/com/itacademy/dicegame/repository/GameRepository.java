package com.itacademy.dicegame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.dicegame.dto.impl.GameResponseDto;
import com.itacademy.dicegame.dto.impl.UserResponseDto;

@Repository
public interface GameRepository extends JpaRepository<GameResponseDto, Integer> {
	
	Iterable<GameResponseDto> findByUser(UserResponseDto user);

}
