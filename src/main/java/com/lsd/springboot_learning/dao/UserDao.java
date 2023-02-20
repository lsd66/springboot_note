package com.lsd.springboot_learning.dao;

import com.lsd.springboot_learning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

public interface UserDao extends JpaRepository<User,Integer>, Serializable {
    /**
     *
     * @param name
     * @return
     */
    @Query("select u from User u where u.name= ?1")
    User getByName(String name);

}
