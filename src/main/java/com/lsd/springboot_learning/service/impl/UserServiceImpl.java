package com.lsd.springboot_learning.service.impl;

import com.lsd.springboot_learning.entity.User;
import com.lsd.springboot_learning.mapper.UserMapper;
import com.lsd.springboot_learning.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author springBoot-Learning
 * @since 2023-02-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
