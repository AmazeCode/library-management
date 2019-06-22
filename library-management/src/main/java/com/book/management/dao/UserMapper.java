package com.book.management.dao;

import com.book.management.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    /**
     * 保存用户信息
     * @param record
     * @return
     */
    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    User findUserByUserName(String userName);

    /**
     * 条件查询用户列表
     * @param map
     * @return
     */
    List<User> selectUserList(Map<String, Object> map);

    /**
     * 条件查询用户总条数
     * @param map
     * @return
     */
    int getTotalUser(Map<String, Object> map);

    /**
     * 校验用户id是否存在
     * @param id
     * @return
     */
    int checkUserIsExist(Long id);

    /**
     * 校验用户信息
     * @param map
     * @return
     */
    int checkUserInfoExist(Map<String,Object> map);

    /**
     * 修改用户状态
     * @param map
     * @return
     */
    int updateUserState(Map<String,Object> map);

    /**
     * 保存用户角色关联信息
     * @param map
     * @return
     */
    int insertUserRoles(Map<String,Object> map);
}