package com.springboot.crud.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
public class Laptop {

    @Id
    private Long laptopId;
    @Column
    private String laptopName;
    @Column
    private String userId;
}
