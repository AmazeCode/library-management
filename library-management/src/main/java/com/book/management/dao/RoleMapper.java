package com.book.management.dao;

import com.book.management.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 根据用户id查询角色信息
     * @param userId
     * @return
     */
    List<Role> findByUserId(Long userId);

    /**
     * 删除用户角色关联
     * @param userId
     * @return
     */
    int deleteRoleUserByUserId(Long userId);

    /**
     * 获取所有角色集合
     * @param map
     * @return
     */
    List<Role> getRolesList(Map<String,Object> map);

    /**
     * 获取角色总数
     * @return
     */
    int getTotalRole();
}