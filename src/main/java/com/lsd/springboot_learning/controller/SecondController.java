package com.lsd.springboot_learning.controller;

import com.lsd.springboot_learning.base.Result;
import com.lsd.springboot_learning.vo.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class SecondController {
    // 加上后面的method的话只能使用Get请求来访问
    @RequestMapping(value = "/second", method = RequestMethod.GET)
    public User second() {
        User u = new User("lsd", 27, "男");
        // 返回一个User类 json数据{"name":"lsd","age":27,"gender":"男"}
        return u;
    }

//    @RequestMapping("/third")
//    public User third(){
//        User u=new User("张胜",50,"男");
//        return u;
//    }

    // Controller中接收Get请求传过来的参数
    // 方式1: 直接在Controller方法的参数中，用相同的变量名接收参数
//    @GetMapping("/third")
//    public String third(String name,Integer age){
//        System.out.println(name);
//        System.out.println(age);
//        return "success";
//    }

    // 如果参数过多,看起来会很乱,可以用JavaBean来进行接收
    @GetMapping("/getParam")
    public User getParam(User user) {
        System.out.println(user);
        // 将接收到的参数直接返回
        return user;
    }

    // Post请求传参方式有两种，一种是form表单，一种是通过json格式（用的多）
    // Form传参
    @PostMapping("/postForm")
    public User postForm(String name, Integer age) {
        User u = new User(name, age, null);
        return u;
    }

    // 如果参数过多，我们也是可以通过一个JavaBean来接收的
    @PostMapping("/postForm2")
    public User postForm2(User user) {
        return user;
    }

    // Json传参
    // 通过json传递的参数，content-type一般为：application/json
    // 在接收参数的时候要通过一个新的注解@RequestBody来进行标识

    // 注意：User中一定要有无参构造方法
    @PostMapping("/postJson")
    public User postJson(@RequestBody User user) {
        return user;
    }

    // 针对context-type是application/x-www-form-urlcoded
    // （Http协议中，如果不指定Content-Type，则默认传递的参数就是application/x-www-form-urlencoded类型）
    @PostMapping("/postWWWForm")
    // @RequestParam在接收普通参数时下可以省略
    // public User postWWWForm( String name, @RequestParam Integer age) {    // 这个时候不传age报bad request
    // 如果要求必填的话 @RequestParam(value="age",required =true) Integer age, // 这个时候不传age报bad request
    public User postWWWForm(@RequestParam String name, @RequestParam(value="age",required =false,defaultValue ="20") Integer age){
        return new User(name, age, null);
    }

    @GetMapping("/login")
    public String login(){
        return "success";
    }

}