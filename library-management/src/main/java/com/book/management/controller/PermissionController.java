package com.book.management.controller;

import com.book.management.annotation.LoginRequired;
import com.book.management.common.DataGridDataSource;
import com.book.management.model.Permission;
import com.book.management.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能菜单Controller
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    /**
     * SERVICE
     */
    @Autowired
    private PermissionService permissionService;

    /**
     * 加载权限树ztree(当前角色已经分配的权限信息会被选中,用于角色模块)
     * @param roleId 角色id
     * @return
     */
    @RequestMapping(value="/loadRolePermissionData",method = {RequestMethod.POST,RequestMethod.POST})
    @LoginRequired
    @ResponseBody
    public Object loadRolePermissionData(Integer roleId) {
        List<Permission> permissions = new ArrayList<>();
        //获取所有权限
        List<Permission> ps = permissionService.queryAll();

        // 获取当前角色已经分配的权限信息
        List<Integer> permissionids = permissionService.queryPermissionIdsByRoleId(roleId);
        //保存权限信息
        Map<Integer, Permission> permissionMap = new HashMap<>();
        for (Permission p : ps) {//循环所有权限信息
            if (permissionids.contains(p.getId())) {//区分已选中的权限信息
                p.setChecked(true);
            } else {
                p.setChecked(false);
            }
            //保存全部信息
            permissionMap.put(p.getId(), p);
        }
        for (Permission p : ps) {
            Permission child = p;
            if (child.getPermissionParentId() == null) {
                permissions.add(p);//顶级目录
            } else {//非顶级目录
                Permission parent = permissionMap.get(child.getPermissionParentId());
                parent.getChildren().add(child);
            }
        }
        return permissions;
    }

    /**
     * 查询应用列表
     */
    @PostMapping("/list")
    @ResponseBody
    @LoginRequired
    public DataGridDataSource<Permission> getPermissionList(){

        List<Permission> permissionTreeDataList = new ArrayList<>();
        //获取权限数据
        List<Permission> permissionList = permissionService.queryAll();
        for(int i = 0;i<permissionList.size();i++){
            Permission permissionTreeData = new Permission();
            permissionTreeData.setId(permissionList.get(i).getId());
            permissionTreeData.setPermissionName(permissionList.get(i).getPermissionName());
            permissionTreeData.setPermissionUrl(permissionList.get(i).getPermissionUrl());
            permissionTreeData.setIcon(permissionList.get(i).getIcon());
            permissionTreeData.setCreateTime(permissionList.get(i).getCreateTime());
            permissionTreeData.setUpdateTime(permissionList.get(i).getUpdateTime());
            permissionTreeData.set_parentId(permissionList.get(i).getPermissionParentId());
            //设置数据
            permissionTreeDataList.add(permissionTreeData);
        }

        DataGridDataSource<Permission> permissionDataGridDataSource = new DataGridDataSource<>();
        //总条数
        permissionDataGridDataSource.setTotal(permissionTreeDataList.size());
        //数据集合
        permissionDataGridDataSource.setRows(permissionTreeDataList);
        //获取所有功能列表
        return permissionDataGridDataSource;
    }
}
