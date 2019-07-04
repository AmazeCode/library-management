package com.book.management.service;

import com.book.management.model.Permission;
import com.book.management.model.User;

import java.util.List;

/**
 * 权限Service
 */
public interface PermissionService {

    /**
     * 查询所有需要验证的路径集合
     * @return
     */
    List<Permission> queryAll();

    /**
     * 获取权限id
     * @param roleId
     * @return
     */
    List<Integer> queryPermissionIdsByRoleId(Integer roleId);

    /**
     * 根据用户信息查找权限集合
     * @param user
     * @return
     */
    List<Permission> queryPermissionsByUser(User user);

    /**
     * 删除角色权限关联
     * @param roleId
     * @return
     */
    int deleteRolePermissionByRoleId(Integer roleId);
}
