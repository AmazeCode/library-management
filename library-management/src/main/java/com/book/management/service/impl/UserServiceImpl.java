package com.book.management.service.impl;

import com.book.management.dao.RoleMapper;
import com.book.management.dao.UserMapper;
import com.book.management.exception.ParamException;
import com.book.management.model.RoleUser;
import com.book.management.model.User;
import com.book.management.service.UserService;
import com.book.management.util.IDUtils;
import com.book.management.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户Service
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    /**
     * Mapper
     */
    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserByUserId(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }

    @Override
    public List<User> selectUserList(Map<String, Object> map) {
        return userMapper.selectUserList(map);
    }

    @Override
    public int getTotalUser(Map<String, Object> map) {
        return userMapper.getTotalUser(map);
    }

    @Override
    public int saveUser(User user) {
        Long id = IDUtils.genUserId();
        if (checkUserIdExist(id)) {
            throw new ParamException("用户ID已经存在,请重新添加");
        }

        if (checkUserNameExist(id, user.getUserName())) {
            throw new ParamException("用户名已被占用");
        }
        if (checkUserEmailExist(id, user.getUserEmail())) {
            throw new ParamException("邮箱已被占用");
        }
        if (checkUserPhoneExist(id, user.getUserPhone())) {
            throw new ParamException("手机号已被占用");
        }

        User users = new User();
        users.setId(id);
        users.setUserName(user.getUserName());
        users.setRealName(user.getRealName());
        users.setUserPassword(Md5Util.md5(user.getUserPassword(), Md5Util.SALT));
        users.setUserEmail(user.getUserEmail());
        users.setUserPhone(user.getUserPhone());
        users.setState(1);//状态：0：禁用；1：启用
        users.setCreateTime(new Date());
        //保存用户信息
        return userMapper.insertSelective(users);
    }

    @Override
    public int updateUser(User user) {
        Long id = user.getId();

        if (checkUserEmailExist(id, user.getUserEmail())) {
            throw new ParamException("邮箱已被占用");
        }
        if (checkUserPhoneExist(id, user.getUserPhone())) {
            throw new ParamException("手机号已被占用");
        }
        //更新时间
        user.setUpdateTime(new Date());

        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean checkUserIdExist(Long id) {
        if(userMapper.checkUserIsExist(id)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean checkUserNameExist(Long id, String userName) {
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("id",id);
        condition.put("userName",userName);
        if(userMapper.checkUserInfoExist(condition)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean checkUserEmailExist(Long id, String userEmail) {
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("id",id);
        condition.put("userEmail",userEmail);
        if(userMapper.checkUserInfoExist(condition)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean checkUserPhoneExist(Long id, String userPhone) {
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("id",id);
        condition.put("userEmail",userPhone);
        if(userMapper.checkUserInfoExist(condition)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int updateUserState(User user) {
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("id",user.getId());
        condition.put("state",user.getState());
        //修改用户状态
        return userMapper.updateUserState(condition);
    }

    @Override
    public int resetPassword(User user) {
        //修改密码
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int insertUserRoles(Map<String, Object> map) {
        return userMapper.insertUserRoles(map);
    }

    @Override
    public int deleteRoleUserByRoleId(Integer roleId) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("roleId",roleId);
        return userMapper.deleteRoleUserByRoleId(map);
    }
}
