package com.book.management.controller;

import com.book.management.annotation.LoginRequired;
import com.book.management.common.DataGridDataSource;
import com.book.management.common.PageBean;
import com.book.management.common.Result;
import com.book.management.model.Permission;
import com.book.management.model.Role;
import com.book.management.model.User;
import com.book.management.service.MailService;
import com.book.management.service.PermissionService;
import com.book.management.service.RoleService;
import com.book.management.service.UserService;
import com.book.management.util.Md5Util;
import com.book.management.util.PasswordCreateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 用户控制层
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * SERVIVE
     */
    @Autowired
    private UserService userService;

    /**
     * SERVICE
     */
    @Autowired
    private RoleService roleService;

    /**
     * SERVICE
     */
    @Autowired
    private PermissionService permissionService;

    /**
     * SERVICE
     */
    @Autowired
    private MailService mailService;

    /**
     * 用户登录
     * @param userName
     * @param userPassword
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    public Result login(@RequestParam(value = "userName") String userName,
                        @RequestParam(value = "userPassword") String userPassword,
                        HttpServletRequest request,
                        HttpSession session) throws Exception {

        if (StringUtils.isEmpty(userName)) {
            return Result.fail("用户名不能为空！");
        }
        if (StringUtils.isEmpty(userPassword)) {
            return Result.fail("密码不能为空！");
        }
        /*if (StringUtils.isEmpty(vaptchaToken)) {
            return JsonData.fail("请进行人机验证！");
        }*/
        User user = userService.findUserByUserName(userName);
        if (user == null) {
            return Result.fail("用户不存在！");
        }
        if (user.getState() == 0) {
            return Result.fail("账号已被禁用！请联系管理员！");
        }
        /*if (!vaptchaCheckService.vaptchaCheck(vaptchaToken, request.getRemoteHost())) {
            return JsonData.fail("人机验证失败！");
        }*/
        if (Md5Util.md5(userPassword, Md5Util.SALT).equals(user.getUserPassword())) {
            // 获取用户角色信息
            List<Role> roleList = roleService.findByUserId(user.getId());
            StringBuffer stringBuffer = new StringBuffer();
            for (Role role : roleList) {
                stringBuffer.append("," + role.getRoleName());
            }
            user.setRoles(stringBuffer.toString().replaceFirst(",", ""));
            // session存放用户信息
            session.setAttribute("user", user);
            // 获取用户权限信息
            List<Permission> permissions = permissionService.queryPermissionsByUser(user);
            Map<Integer, Permission> permissionMap = new HashMap<>();
            Permission root = null;
            Set<String> uriSet = new HashSet<>();
            for (Permission permission : permissions) {
                permissionMap.put(permission.getId(), permission);
                if (permission.getPermissionUrl() != null && !"".equals(permission.getPermissionUrl())) {
                    uriSet.add(permission.getPermissionUrl());
                }
            }
            session.setAttribute("authUriSet", uriSet);
            //封装菜单数据
            for (Permission permission : permissions) {
                Permission child = permission;
                if (child.getPermissionParentId() == null) {
                    root = permission;
                } else {
                    Permission parent = permissionMap.get(child.getPermissionParentId());
                    parent.getChildren().add(child);
                }
            }
            session.setAttribute("rootPermission", root);
            return Result.success();
        } else {
            return Result.fail("用户名或密码错误！");
        }
    }


    /**
     * 带条件查询用户列表
     * @param userName
     * @param realName
     * @param userEmail
     * @param userPhone
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/list")
    @LoginRequired //需要登陆验证
    public DataGridDataSource<User> getUserList(@RequestParam(value = "userName", required = false, defaultValue = "") String userName,
                                                @RequestParam(value = "realName", required = false, defaultValue = "") String realName,
                                                @RequestParam(value = "userEmail", required = false, defaultValue = "") String userEmail,
                                                @RequestParam(value = "userPhone", required = false, defaultValue = "") String userPhone,
                                                @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                @RequestParam(value = "rows", required = false, defaultValue = "5") Integer pageSize){
        PageBean pageBean = new PageBean(page,pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userName", userName);
        map.put("realName", realName);
        map.put("userEmail", userEmail);
        map.put("userPhone", userPhone);
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<User> userList = userService.selectUserList(map);
        //查询用户角色
        for(User user : userList){
            //查询用户表角色列表
            List<Role> roleList = roleService.findByUserId(user.getId());
            StringBuffer stringBuffer = new StringBuffer();
            for (Role role : roleList) {
                stringBuffer.append("," + role.getRoleName());
            }
            user.setRoles(stringBuffer.toString().replaceFirst(",", ""));
        }
        //条件查询用户总条数
        int totalUser = userService.getTotalUser(map);
        //封装分页数据
        DataGridDataSource<User> dataGridDataSource = new DataGridDataSource<>();
        //总条数
        dataGridDataSource.setTotal(totalUser);
        //显示的条数
        dataGridDataSource.setRows(userList);
        return dataGridDataSource;
    }


    /**
     * 添加用户
     * @param user
     * @return
     */
    //GET产生一个TCP数据包；POST产生两个TCP数据包
    //get方式把参数包含到url中,post的参数把通过request body传输参数
    @PostMapping("/save")//@PostMapping是一个作为快捷方式的组合注释@RequestMapping(method = RequestMethod.POST)
    @LoginRequired//需要登录
    public Result saveUser(User user){
        //保存用户信息
        int count = userService.saveUser(user);

        if(count>0){
            return Result.success(count,"添加成功！");
        }else{
            return Result.fail("添加失败！");
        }
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/update")
    @LoginRequired
    public Result updateUser(User user){
        int count = userService.updateUser(user);

        if (count>0){
            return Result.success(count,"修改成功！");
        }else{
            return Result.fail("修改失败！");
        }
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @LoginRequired
    public Result deletUser(@RequestParam("id") String id){
        //删除用户前先根据用户id将用户角色关联表的记录删除
        roleService.deleteRoleUserByUserId(Long.valueOf(id));

        int count = userService.deleteUser(Long.valueOf(id));
        if (count > 0) {
            return Result.success(count, "删除成功");
        } else {
            return Result.fail("删除失败");
        }
    }

    /**
     * 启用用户
     * @param id
     * @return
     */
    @PostMapping("/enable")
    @LoginRequired
    public Result enableUser(@RequestParam("id") Long id){

        User user = new User();
        user.setId(id);
        //启用用户
        user.setState(1);
        int count = userService.updateUserState(user);

        if (count>0){
            return Result.success(count,"启用成功！");
        }else{
            return Result.fail("启用失败！");
        }
    }

    /**
     * 禁用用户
     * @param id
     * @return
     */
    @PostMapping("/disable")
    @LoginRequired
    public Result disableUser(@RequestParam("id") Long id){

        User user = new User();
        user.setId(id);
        //停用用户
        user.setState(0);
        //修改用户状态
        int count = userService.updateUserState(user);

        if (count>0){
            return Result.success(count,"禁用成功！");
        }else{
            return Result.fail("禁用失败！");
        }
    }

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @param session
     * @return
     */
    @PostMapping("/modifyPassword")
    @LoginRequired
    public Result modifyPassword(String oldPassword, String newPassword, HttpSession session) {

        User currentUser = (User) session.getAttribute("user");
        User user = userService.findUserByUserId(currentUser.getId());
        if (!Md5Util.md5(oldPassword, Md5Util.SALT).equals(user.getUserPassword())) {
            return Result.fail("原密码错误");
        }
        user.setUserPassword(Md5Util.md5(newPassword, Md5Util.SALT));
        int i = userService.updateUser(user);
        if (i > 0) {
            return Result.success(i, "修改成功");
        } else {
            return Result.fail("修改失败");
        }
    }

    /**
     * 重置密码，以及发送邮件
     * @param toMail
     * @param id
     * @return
     */
    @PostMapping("/sendMail")
    @LoginRequired
    public Result sendEmail(@RequestParam(value = "toMail") String toMail,
                            @RequestParam(value = "userId") Long id){
        if (StringUtils.isEmpty(toMail)) {
            return Result.fail("用户邮箱不能为空");
        }
        //随机生成密码
        String defaultPassword = PasswordCreateUtil.createPassWord(8);
        User user = new User();
        user.setId(id);
        //加密密码
        user.setUserPassword(Md5Util.md5(defaultPassword,Md5Util.SALT));
        int count = userService.resetPassword(user);
        if (count > 0) {
            mailService.sendPasswordMail(toMail, "重置密码", "您的初始密码为：" + defaultPassword);
            return Result.success(count, "重置密码成功");
        } else {
            return Result.fail("重置密码失败");
        }
    }


    /**
     * 保存角色设置
     * @param userId 用户id
     * @param roleIds 角色id集合
     * @return
     */
    @PostMapping("/saveRoleSet")
    @LoginRequired
    public Result saveRoleSet(Long userId, Integer[] roleIds){

        //删除原有用户角色设置
        roleService.deleteRoleUserByUserId(userId);

        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("roleIds", roleIds);
        int count = userService.insertUserRoles(map);
        if (count > 0) {
            return Result.success(count, "设置成功");
        } else {
            return Result.fail("设置失败");
        }
    }
}
