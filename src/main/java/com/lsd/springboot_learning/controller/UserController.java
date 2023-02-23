package com.lsd.springboot_learning.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lsd.springboot_learning.base.Result;
import com.lsd.springboot_learning.entity.User;
import com.lsd.springboot_learning.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author springBoot-Learning
 * @since 2023-02-22
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 构造方法注入
     */
    private final IUserService userService;

    public UserController (IUserService userService){
        this.userService=userService;
    }

    @GetMapping("/save")
    public Result save(){
        User user=new User();
        user.setAge(18);
        user.setAddress("北京王府井大街");
        user.setName("张某某");
        userService.save(user);

        return Result.success();
    }


    @GetMapping("/update")
    public Result update(Integer id){
        User user =new User();
        user.setId(id);
        user.setName("修改的名字");
        userService.updateById(user);

        return Result.success();
    }


    @GetMapping("/list")
    public Result list(){
        // 返回所有
        List<User> list = userService.list();
        return Result.success(list);
    }


    @GetMapping("/listByContion")
    public Result listByContion(){
        /**
         * 条件查询， 通过QueryWrapper来实现查询的条件：
         * eq: 代表相等
         * like: 模糊匹配
         * orderBy: 排序
         * in, notin
         * 大于，小于，between等
         */
        List<User> list = userService.list(new LambdaQueryWrapper<User>()
                // 查询年龄=11的
                .eq(User::getAge, 11)
                // 模糊匹配
                .like(User::getName, "%张%")
                // 排序，按照创建时间
                .orderByDesc(User::getCreateTime)
        );
        return Result.success(list);
    }

    @GetMapping("/getById")
    public Result getById(Integer id){
        User user = userService.getById(id);
        return Result.success(user);
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        userService.removeById(id);
        return Result.success();
    }

    @GetMapping("/page")
    public Result page(int pageNum, int pageSize, String name){
        IPage<User> page = new Page<>(pageNum, pageSize);

        IPage<User> page1 = userService.page(page, new LambdaQueryWrapper<User>()
                // 主要演示这里可以加条件。在name不为空的时候执行
                .eq(StringUtils.isNotEmpty(name), User::getName, "%" + name + "%"));

        return Result.success(page1);
    }

}
