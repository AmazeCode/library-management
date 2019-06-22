package com.book.management.dao;

import com.book.management.model.Permission;
import com.book.management.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 查询所有记录
     * @return
     */
    List<Permission> queryAll();

    /**
     * 根据用户信息查看权限信息
     * @param user
     * @return
     */
    List<Permission> queryPermissionsByUser(User user);
}