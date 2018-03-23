package com.example.demo.util;

import com.example.demo.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Vic Zhang
 * @date 2018/3/23 上午10:39
 */
public class ResultUtil {
//    @Autowired
//    private Result result;
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }
    public static Result success() {
        return success(null);
    }
    public static Result fail(String str) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg(str);
//        result.setData(object);
        return result;
    }
}
