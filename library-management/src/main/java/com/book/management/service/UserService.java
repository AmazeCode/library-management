package com.book.management.service;

import com.book.management.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 根据id查看用户信息
     * @param id
     * @return
     */
    User findUserByUserId(Long id);

    /**
     * 根据登录名查找用户信息
     * @param userName
     * @return
     */
    User findUserByUserName(String userName);

    /**
     * 条件查询用户集合
     * @param map
     * @return
     */
    List<User> selectUserList(Map<String,Object> map);

    /**
     * 条件查询用户总条数
     * @param map
     * @return
     */
    int getTotalUser(Map<String,Object> map);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    int deleteUser(Long id);

    /**
     * 校验用户id是否存在
     * @param id
     * @return
     */
    boolean checkUserIdExist(Long id);

    /**
     * 校验用户名是否存在
     * @param id
     * @param userName
     * @return
     */
    boolean checkUserNameExist(Long id,String userName);

    /**
     * 校验用户Email是否存在
     * @param id
     * @param userEmail
     * @return
     */
    boolean checkUserEmailExist(Long id,String userEmail);

    /**
     * 校验用户手机号是否存在
     * @param id
     * @param userPhone
     * @return
     */
    boolean checkUserPhoneExist(Long id,String userPhone);

    /**
     * 修改用户状态
     * @param user
     * @return
     */
    int updateUserState(User user);

    /**
     * 重置密码
     * @param user
     * @return
     */
    int resetPassword(User user);

    /**
     * 保存用户角色关联信息
     * @param map
     * @return
     */
    int insertUserRoles(Map<String,Object> map);

    /**
     *  删除用户角色关联
     * @param roleId
     * @return
     */
    int deleteRoleUserByRoleId(Integer roleId);
}
