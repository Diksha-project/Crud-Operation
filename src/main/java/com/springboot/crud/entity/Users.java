package com.springboot.crud.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.util.ArrayList;

@Data
@Entity
@Table(name ="crud_operation")

public class Users {
	
	@Id
    private Long id;
	
	@Column(name = "USERNAME")
	private String Username;
	
	@Column(name = "EMAIL")
	private String Email;
	
	
	@Column(name= "PASSWORD")
	private String Password;

    @Transient
	private ArrayList<Book> books = new ArrayList<>();

}
