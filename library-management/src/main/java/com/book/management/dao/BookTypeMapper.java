package com.book.management.dao;

import com.book.management.model.BookType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookType record);

    int insertSelective(BookType record);

    BookType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookType record);

    int updateByPrimaryKey(BookType record);
}