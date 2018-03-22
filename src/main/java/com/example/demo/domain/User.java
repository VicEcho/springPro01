package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;

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
    @Min(value = 101, message  =  "编号代码从101开始")
    private String code;

}
