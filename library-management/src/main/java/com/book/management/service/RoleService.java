package com.book.management.service;

import com.book.management.model.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {

    /**
     * 根据用户id查询角色信息
     * @param id
     * @return
     */
    List<Role> findByUserId(Long id);

    /**
     * 删除用户角色信息
     * @param userId
     */
    void deleteRoleUserByUserId(Long userId);

    /**
     * 获取角色集合
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
