package com.password.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.password.entity.Users;
import com.password.repository.signUpRepository;

import com.password.web.dto.signUpDto;

@Service
public class signUpServiceImp implements signUpService{
	
	@Autowired
	private signUpRepository SignUpRepository;
	
	
	

//	public signUpServiceImp(signUpRepository signUpRepository) {
//		super();
//		SignUpRepository = signUpRepository;
//	}



//	@Override
//	public Users save(signUpDto SignUpDto) {
////		Users users = new Users(signUpDto.get;
//		
//		Users user = new Users(SignUpDto.get)
//		
//		return SignUpRepository.save(SignUpDto);
//	}
	


}
