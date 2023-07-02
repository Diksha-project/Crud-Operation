package com.springboot.crud.controller;

import java.util.ArrayList;
import java.util.List;

import com.springboot.crud.entity.Book;
import com.springboot.crud.externalServices.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.dto.SignUpDto;
import com.springboot.crud.entity.Users;
import com.springboot.crud.repository.signUpRepository;
import com.springboot.crud.service.signUpService;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/user")
@RestController
public class signUpController {
    @Autowired
	private BookService bookService;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private signUpRepository SignUpRepository;
	
	@Autowired
	private signUpService SignUpService;
	
	

@PostMapping("/signUpUser")
public ResponseEntity<Users> signUpUser(@RequestBody  SignUpDto user) {
    Users newUser = SignUpService.signUpUser(user.getId(),user.getUsername(),user.getEmail(),user.getPassword());
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	
}

@PostMapping("/login")
public ResponseEntity<String> Login(@RequestParam("email") String Email,@RequestParam("password") String password) {

	String message = SignUpService.login( Email,password);
	return new ResponseEntity<>(message, HttpStatus.OK);
	
}

@GetMapping("/{id}")
public ResponseEntity<Users> GetUserById (@PathVariable("id") Long id) {
System.out.println(id);
	Users user = SignUpService.GetUserById(id);
	ArrayList<Book> book = restTemplate.getForObject("http://localhost:8081/book/user/"+id,ArrayList.class);
	user.setBooks(book);
	return new ResponseEntity<>(user, HttpStatus.OK);
	
}


@GetMapping("/getAll")
public ResponseEntity<List<Users>> GetAll () {

		List<Users> users = SignUpService.GetAll();
		List<Book> books = bookService.getAllBook();


	for (Users user: users) {
		ArrayList<Book> booklist = new ArrayList<>();

		for (Book book:books) {

			if(book.getUserId().equals(user.getId())){
				booklist.add(book);
				break;
			}

		}
		user.setBooks(booklist);
	}

		return ResponseEntity.ok(users);
	}


@PostMapping("/deleteById/{id}")
public ResponseEntity<List<Users>> DeleteById (@PathVariable("id") Long id) {

	List<Users> user = SignUpService.DeleteById(id);
	
	return new ResponseEntity<>(user, HttpStatus.OK);}
	

	@PutMapping("/update/{id}")
	public ResponseEntity<Users> UpdateById (@PathVariable("id") Long id,@RequestBody  SignUpDto signUpDto) {
	
		Users user1 = SignUpService.UpdateById(id,signUpDto);
		
		return new ResponseEntity<>(user1, HttpStatus.OK);
	
}


	
}

