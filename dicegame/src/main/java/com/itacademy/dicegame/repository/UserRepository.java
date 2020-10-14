package com.itacademy.dicegame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.dicegame.dto.impl.UserResponseDto;

@Repository
public interface UserRepository extends JpaRepository<UserResponseDto,Integer>{

}
