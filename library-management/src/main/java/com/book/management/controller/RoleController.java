package com.book.management.controller;

import com.book.management.annotation.LoginRequired;
import com.book.management.common.DataGridDataSource;
import com.book.management.common.PageBean;
import com.book.management.common.Result;
import com.book.management.model.Role;
import com.book.management.service.PermissionService;
import com.book.management.service.RoleService;
import com.book.management.service.UserService;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserService userService;

    /**
     * 查询角色列表
     * @param roleName 角色名称
     * @param page
     * @param rows
     * @return
     */
    @PostMapping("/list")
    @LoginRequired
    public DataGridDataSource<Role> getRoleList(@RequestParam(value = "roleName", required = false, defaultValue = "") String roleName,
                                                @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                @RequestParam(value = "rows", required = false, defaultValue = "5") Integer rows){
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> map = new HashMap<>();
        map.put("roleName",roleName);
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

    /**
     * 保存角色信息
     * @param role
     * @return
     */
    @PostMapping("/save")
    @LoginRequired
    public Result saveRole(Role role){
        int count = roleService.saveRole(role);
        if (count > 0){
            return Result.success(count,"添加成功!!!");
        }else{
            return Result.fail("添加失败!!!");
        }
    }

    /**
     * 更新角色信息
     * @param role
     * @return
     */
    @PutMapping("/update")
    @LoginRequired
    public Result updateRole(Role role){
        int count = roleService.updateRole(role);
        if (count > 0){
            return Result.success(count,"更新成功!!!");
        }else{
            return Result.fail("更新失败!!!");
        }
    }

    /**
     * 删除角色信息
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    @LoginRequired
    public Result deleteRole(@RequestParam("id") Integer id){
        //根据角色删除，用户关联
        userService.deleteRoleUserByRoleId(id);
        //根据角色删除权限关联
        permissionService.deleteRolePermissionByRoleId(id);
        //删除角色信息
        int count = roleService.deleteRoleById(id);
        if(count>0){
            return Result.success(count,"删除成功！");
        }else{
            return Result.fail("删除失败！");
        }
    }

    /**
     * 删除角色权限重新设置
     * @param roleId
     * @param permissionIds
     * @return
     */
    @PostMapping("/savePermissionSet")
    @LoginRequired
    @ResponseBody
    public Result savePermissionSet(Integer roleId, Integer[] permissionIds){

        //删除当前角色拥有的权限
        permissionService.deleteRolePermissionByRoleId(roleId);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("roleId",roleId);
        map.put("permissionIds",permissionIds);
        int count = roleService.insertRolePermissions(map);
        if(count>0){
            return Result.success(count,"设置成功！");
        }else{
            return Result.fail("设置失败！");
        }
    }
}
