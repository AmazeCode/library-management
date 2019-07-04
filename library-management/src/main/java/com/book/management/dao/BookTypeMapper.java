package com.book.management.dao;

import com.book.management.model.BookType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookType record);

    int insertSelective(BookType record);

    BookType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookType record);

    int updateByPrimaryKey(BookType record);

    /**
     * 查询图书类型集合
     * @param map
     * @return
     */
    List<BookType> selectBookTypeListByBookTypeId(Map<String,Object> map);

    /**
     * 查询所有图书类型
     * @return
     */
    List<BookType> queryAllBookType();

    /**
     * 统计图书类型
     * @param map
     * @return
     */
    int countByBookTypeName(Map<String,Object> map);
}