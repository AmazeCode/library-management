package com.book.management.dao;

import com.book.management.model.LendBack;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LendBackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LendBack record);

    int insertSelective(LendBack record);

    LendBack selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LendBack record);

    int updateByPrimaryKey(LendBack record);
}