package com.book.management.dao;

import com.book.management.model.LendBack;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LendBackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LendBack record);

    int insertSelective(LendBack record);

    LendBack selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LendBack record);

    int updateByPrimaryKey(LendBack record);

    /**
     * 查询图书信息
     * @return
     */
    List<LendBack> selectBookInfoAndUserByBookId(Integer bookId);

    /**
     * 分页查询借书记录
     * @param map
     * @return
     */
    List<LendBack> selectLendReturnRecordByUserId(Map<String, Object> map);

    /**
     * 借书总条数
     * @param map
     * @return
     */
    int getTotalRecord(Map<String, Object> map);
}