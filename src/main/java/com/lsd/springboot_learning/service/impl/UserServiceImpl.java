package com.lsd.springboot_learning.service.impl;

import com.lsd.springboot_learning.entity.User;
import com.lsd.springboot_learning.jdbcTemplate.UserDao;
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
        return userDao.getByUserId(id);
    }

    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }

    @Override
    public int save(User user) {
        return userDao.save(user);
    }

    @Override
    public int update(Integer id, User user) {
        return userDao.update(id,user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }
}
