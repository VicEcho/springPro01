package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "nnn",nullable = true)
    @Column
    private String name;

    @Column
    private String code;

}
