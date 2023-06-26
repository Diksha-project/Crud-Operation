package com.springboot.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

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
	

}
