package com.lsd.springboot_learning.controller;

import com.lsd.springboot_learning.base.ResultCode;
import com.lsd.springboot_learning.exception.BizException;
import com.lsd.springboot_learning.vo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdController {
    @GetMapping("exception")
    public User second(){
        System.out.println(1);
        throw new BizException(ResultCode.BIZ_ERROR.getCode(),"用户名密码错误");
    }
}
