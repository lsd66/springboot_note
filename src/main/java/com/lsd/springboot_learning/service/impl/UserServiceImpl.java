package com.lsd.springboot_learning.service.impl;

import com.lsd.springboot_learning.dao.UserDao;
import com.lsd.springboot_learning.entity.User;

import com.lsd.springboot_learning.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    // 构造方法注入，相当于@Autowired,测试的确是的
    private  final UserDao userDao;
    public UserServiceImpl(UserDao userDao){
        this.userDao=userDao;
    }

//    @Resource
//    private  UserDao userDao;


    @Override
    public User getUserById(Integer id) {
        return userDao.getReferenceById(id);
    }

    @Override
    public List<User> listUser() {
        return userDao.findAll();
    }

    @Override
    public int save(User user) {
        userDao.save(user);
        return user.getId();
    }

    @Override
    public int update(Integer id, User user) {
        // 有id则更新，无id则新增
        user.setId(id);
        userDao.save(user);
        return id;
    }

    @Override
    public int delete(Integer id) {
        User user=new User();
        user.setId(id);
        userDao.delete(user);
        return id;
    }

    @Override
    public User getByName(String name){
        return userDao.getByName(name);
    }
}
