package com.springboot.crud.service;


import java.util.List;

import com.springboot.crud.dto.SignUpDto;
import com.springboot.crud.entity.Users;

public interface signUpService {
	




public Users signUpUser(Long user_id, String username,String email, String password);

public String login(String email, String password);

public Users GetUserById(Long id);

public List<Users> GetAll();

public List<Users> DeleteById(Long id);






public Users UpdateById(Long id, SignUpDto signUpDto);







}