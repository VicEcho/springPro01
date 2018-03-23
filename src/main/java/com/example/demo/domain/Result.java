package com.example.demo.domain;

import lombok.Data;

/**
 *
 * @author Vic Zhang
 * @date 2018/3/22 下午4:37
 */
@Data
public class Result<T> {
    private Integer code;

    private String msg;

    private T data;


}
