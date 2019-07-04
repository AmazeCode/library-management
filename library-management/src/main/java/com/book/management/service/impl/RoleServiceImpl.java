package com.book.management.service.impl;

import com.book.management.dao.RoleMapper;
import com.book.management.exception.ParamException;
import com.book.management.model.Role;
import com.book.management.service.RoleService;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    /**
     * 角色Mapper
     */
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findByUserId(Long id) {
        return roleMapper.findByUserId(id);
    }

    @Override
    public int deleteRoleUserByUserId(Long userId) {
        return roleMapper.deleteRoleUserByUserId(userId);
    }

    @Override
    public List<Role> getRolesList(Map<String, Object> map) {

        return roleMapper.getRolesList(map);
    }

    @Override
    public int getTotalRole() {
        return roleMapper.getTotalRole();
    }

    @Override
    public int saveRole(Role role) {
        if(checkRoleNameIsExist(role.getRoleName(),role.getId())){
            throw new ParamException("角色名已被占用");
        }
        Role roles = new Role();
        roles.setRoleName(role.getRoleName());
        roles.setCreateTime(new Date());
        //执行保存
        return roleMapper.insertSelective(roles);
    }

    @Override
    public int updateRole(Role role) {

        if(checkRoleNameIsExist(role.getRoleName(),role.getId())){
            throw new ParamException("角色名已被占用");
        }
        //查找要更改的角色信息
        Role before = roleMapper.selectByPrimaryKey(role.getId());
        Preconditions.checkNotNull(before, "需更新的角色不存在");
        Role roles = new Role();
        roles.setRoleName(role.getRoleName());
        roles.setId(role.getId());
        roles.setUpdateTime(new Date());
        //执行更新
        return roleMapper.updateByPrimaryKeySelective(roles);
    }

    @Override
    public boolean checkRoleNameIsExist(String roleName, Integer id) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("roleName",roleName);
        map.put("id",id);
        return roleMapper.countByRoleName(map) > 0;
    }

    @Override
    public int deleteRoleById(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertRolePermissions(Map<String, Object> map) {
        return roleMapper.insertRolePermissions(map);
    }
}
