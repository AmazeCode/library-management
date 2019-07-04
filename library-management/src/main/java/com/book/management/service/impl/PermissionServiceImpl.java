package com.book.management.service.impl;

import com.book.management.dao.PermissionMapper;
import com.book.management.model.Permission;
import com.book.management.model.User;
import com.book.management.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("permissionService")
@Transactional
public class PermissionServiceImpl implements PermissionService {

    /**
     * Mapper
     */
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Integer> queryPermissionIdsByRoleId(Integer roleId) {
        return permissionMapper.queryPermissionIdsByRoleId(roleId);
    }

    @Override
    public List<Permission> queryAll() {
        //查询所有权限
        return permissionMapper.queryAll();
    }

    @Override
    public List<Permission> queryPermissionsByUser(User user) {
        return permissionMapper.queryPermissionsByUser(user);
    }

    @Override
    @Transactional
    public int deleteRolePermissionByRoleId(Integer roleId) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("roleId",roleId);
        return permissionMapper.deleteRolePermissionByRoleId(map);
    }
}
