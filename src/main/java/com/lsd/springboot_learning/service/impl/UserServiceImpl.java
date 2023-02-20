package com.lsd.springboot_learning.service.impl;

import com.lsd.springboot_learning.entity.User;
import com.lsd.springboot_learning.mapper.UserMapper;
import com.lsd.springboot_learning.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    // 构造方法注入，相当于@Autowired,测试的确是的
    private  final UserMapper userDao;
    public UserServiceImpl(UserMapper  userDao){
        this.userDao=userDao;
    }

//    @Resource
//    private  UserDao userDao;

    @Override
    public User getUserById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public int save(User user) {
        return userDao.insert(user);
    }

    @Override
    public int update(Integer id, User user) {
        user.setId(id);
        return userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }
}
