package com.springboot.crud.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
public class Book {


	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "Bid")
    private Long id;
	
	@Column(name = "BOOK_NAME")
	private String bookName;
	
	@Column(name = "BOOK_DESC")
	private String bookDesc;

	@Column(name = "USER_ID")
	private String userId;

	
}
