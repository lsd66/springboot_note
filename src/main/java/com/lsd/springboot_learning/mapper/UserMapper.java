package com.lsd.springboot_learning.mapper;

import com.lsd.springboot_learning.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 删除操作
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入操作
     *
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 插入操作：只会插入数据不为null的字段值
     *
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 根据id查询操作
     *
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 更新操作
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 更新操作
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

}
