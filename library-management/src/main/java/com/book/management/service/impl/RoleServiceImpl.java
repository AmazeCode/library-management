package com.book.management.service.impl;

import com.book.management.dao.RoleMapper;
import com.book.management.model.Role;
import com.book.management.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("roleService")
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
    @Transactional
    public void deleteRoleUserByUserId(Long userId) {
        roleMapper.deleteRoleUserByUserId(userId);
    }

    @Override
    public List<Role> getRolesList(Map<String, Object> map) {

        return roleMapper.getRolesList(map);
    }

    @Override
    public int getTotalRole() {
        return roleMapper.getTotalRole();
    }
}
