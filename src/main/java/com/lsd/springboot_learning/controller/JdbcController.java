package com.lsd.springboot_learning.controller;

import com.lsd.springboot_learning.base.Result;
import com.lsd.springboot_learning.entity.User;
import com.lsd.springboot_learning.exception.BizException;
import com.lsd.springboot_learning.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("jdbc")
public class JdbcController {
    // 构造方法注入，相当于@Autowired
    private  final UserService userService;
    public JdbcController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("save")
    public Result save(@RequestBody User user){
        userService.save(user);
        return Result.success();
    }

    @PostMapping("update")
    public Result update(@RequestBody User user){
        if (user.getId()==null) {
            throw new BizException("更新操作id不能为空");
        }
        userService.update(user.getId(),user);
        return Result.success();
    }

    @GetMapping("get/{id}")
    public Result getById(@PathVariable Integer id){
        return Result.success(userService.getUserById(id));
    }

    @GetMapping("list")
    public Result list(){
        return Result.success(userService.listUser());
    }

    @GetMapping("delete/{id}")
    public Result delete (@PathVariable Integer id){
        userService.delete(id);
        return Result.success();
    }

}
