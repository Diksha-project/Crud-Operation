package com.springboot.crud.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.springboot.crud.dto.SignUpDto;
import com.springboot.crud.entity.Users;
import com.springboot.crud.repository.signUpRepository;
import java.util.Optional;

@Service
public class signUpServiceImp implements signUpService{
	
	@Autowired
	private signUpRepository SignUpRepository;
   // private signUpService SignUpService;
	
	//private SignUpDto signUpDto;
	
	

	@Override
	public Users signUpUser(Long id, String username, String email, String password) {
		//To validate input
				if (StringUtils.isEmpty(username)|| StringUtils.isEmpty(password) ) {
		            throw new IllegalArgumentException("Missing required fields");
		        }
				
				// create new user
			//Users newUser= new Users();
			Users newUser = new Users();

			newUser.setId(id);
			newUser.setUsername(username);
			newUser.setPassword(password);
			newUser.setEmail(email);
				
		        // save user to database
		        SignUpRepository.save(newUser);

		        return newUser;
	}


	@Override
	public String login(String email, String password) {

		List<Users> userlist = new ArrayList<Users>();
		
		SignUpRepository.findAll().forEach(userlist::add);
		for (Users user : userlist) {
    if (email != null && email.equals(user.getEmail()) &&
        password != null && password.equals(user.getPassword())) {
        return "You are logged in";
    }
}

return "Invalid email or password";
	
		
	}

		
	@Override
	public Users GetUserById(Long id) {
		Users user = SignUpRepository.findById(id).get();
		return user;
		
	}

	@Override
	public List<Users> GetAll() {
		
		List<Users> userlist = new ArrayList<>();
	
			SignUpRepository.findAll().forEach(userlist::add);
			return userlist;
	}



	@Override
	public List<Users> DeleteById(Long id) {
		List<Users> userlist = new ArrayList<>();
		//List<Users> user = 
				SignUpRepository.deleteById(id);
				SignUpRepository.findAll().forEach(userlist::add);
				return userlist;
	}

	
	
	
	@Override
	public Users UpdateById(Long id, SignUpDto signUpDto) {
	    Optional<Users> optionalUser = SignUpRepository.findById(id);
	    if (optionalUser.isPresent()) {
	        Users user = optionalUser.get();
	        user.setUsername(signUpDto.getUsername());
	        user.setEmail(signUpDto.getEmail());
	        user.setPassword(signUpDto.getPassword());
	        return SignUpRepository.save(user);
	    }
	    return null; // or throw an exception
	}



	
}
