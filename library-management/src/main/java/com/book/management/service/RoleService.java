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
     * 删除用户角色关联信息
     * @param userId
     */
    int deleteRoleUserByUserId(Long userId);

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

    /**
     * 添加角色信息
     * @param role
     * @return
     */
    int saveRole(Role role);

    /**
     * 更新角色信息
     * @param role
     * @return
     */
    int updateRole(Role role);

    /**
     * 校验角色名称是否存在
     * @param roleName
     * @param id
     * @return
     */
    boolean checkRoleNameIsExist(String roleName,Integer id);

    /**
     * 删除角色信息
     * @param id
     * @return
     */
    int deleteRoleById(Integer id);

    /**
     * 保存角色权限
     * @param map
     * @return
     */
    int insertRolePermissions(Map<String,Object> map);
}
