package com.password.service;


import com.password.entity.Users;
import com.password.web.dto.signUpDto;

public interface signUpService {
	
Users save(signUpDto SignUpDto);	

}
