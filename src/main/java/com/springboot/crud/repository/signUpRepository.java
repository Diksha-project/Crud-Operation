package com.springboot.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crud.dto.SignUpDto;
import com.springboot.crud.entity.Users;

public interface signUpRepository extends JpaRepository<Users,Long>{

	Users save(SignUpDto signUpDto);

	

}
