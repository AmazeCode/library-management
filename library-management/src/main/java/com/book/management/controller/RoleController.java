package com.book.management.controller;

import com.book.management.annotation.LoginRequired;
import com.book.management.common.DataGridDataSource;
import com.book.management.common.PageBean;
import com.book.management.model.Role;
import com.book.management.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色控制层
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/list")
    @LoginRequired
    public DataGridDataSource<Role> getRoleList(@RequestParam(value = "roleName", required = false, defaultValue = "") String roleName,
                                                @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                @RequestParam(value = "rows", required = false, defaultValue = "5") Integer rows){
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> map = new HashMap<>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        //获取角色集合
        List<Role> rolesList = roleService.getRolesList(map);
        //获取角色总数
        int count = roleService.getTotalRole();
        DataGridDataSource<Role> dataGridDataSource = new DataGridDataSource<Role>();
        //总集合数
        dataGridDataSource.setRows(rolesList);
        //总条数
        dataGridDataSource.setTotal(count);

        return dataGridDataSource;
    }
}
