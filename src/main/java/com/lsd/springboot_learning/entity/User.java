package com.lsd.springboot_learning.entity;


import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private Date createTime;
    private Date updateTime;
}
