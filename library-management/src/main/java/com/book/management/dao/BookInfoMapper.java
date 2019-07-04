package com.book.management.dao;

import com.book.management.model.BookInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKeyWithBLOBs(BookInfo record);

    int updateByPrimaryKey(BookInfo record);

    /**
     * 分页查询图书集合
     * @param map
     * @return
     */
    List<BookInfo> selectBookInfoList(Map<String,Object> map);

    /**
     * 条件查询图书总条数
     * @param map
     * @return
     */
    int getTotalBook(Map<String,Object> map);
}