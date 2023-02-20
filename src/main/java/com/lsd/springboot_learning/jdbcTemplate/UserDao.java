package com.lsd.springboot_learning.jdbcTemplate;

import com.lsd.springboot_learning.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao {
    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    User getByUserId(Integer id);  //注意导实体类的包

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> listUser();

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 更新用户
     *
     * @param id
     * @param user
     * @return
     */
    int update(Integer id, User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int delete(Integer id);

}
