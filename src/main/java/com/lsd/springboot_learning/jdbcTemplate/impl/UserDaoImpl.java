package com.lsd.springboot_learning.jdbcTemplate.impl;

import com.lsd.springboot_learning.entity.User;
import com.lsd.springboot_learning.jdbcTemplate.UserDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

// @Repository的功能是将数据访问层（Dao层）的类识别并标注为SpringBean，
// 具体方式为直接在DAO类上标注即可。
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getByUserId(Integer id) {
        User user = jdbcTemplate.queryForObject("select *  from t_user where id=?",
                new BeanPropertyRowMapper<User>(User.class), id);   // BeanPropertyRowMapper将数据库查询结果转为Java对象
        return user;
    }

    @Override
    public List<User> listUser() {
        List<User> users = jdbcTemplate.query("select * from t_user", new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public int save(User user) {
        return jdbcTemplate.update("insert into t_user(name, age, address, create_time, update_time) values(?, ?, ?,?,?)",
                user.getName(), user.getAge(), user.getAddress(), new Date(), new Date());
    }

    @Override
    public int update(Integer id, User user) {
        return jdbcTemplate.update("UPDATE t_user SET name = ? , age = ? ,address = ? ,update_time = ? WHERE id=?",
                user.getName(), user.getAge(), user.getAddress(), new Date(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("DELETE from tb_user where id = ? ", id);
    }
}
