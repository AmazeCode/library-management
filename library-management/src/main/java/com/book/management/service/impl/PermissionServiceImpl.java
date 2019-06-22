package com.book.management.service.impl;

import com.book.management.dao.PermissionMapper;
import com.book.management.model.Permission;
import com.book.management.model.User;
import com.book.management.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    /**
     * Mapper
     */
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> queryAll() {
        //查询所有权限
        return permissionMapper.queryAll();
    }

    @Override
    public List<Permission> queryPermissionsByUser(User user) {
        return permissionMapper.queryPermissionsByUser(user);
    }
}
