package com.book.management.service;

import com.book.management.model.LendBack;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface LendBookService {

    /**
     * 借书
     * @param lendBack
     * @return
     * @throws ParseException
     */
    int lendBook(LendBack lendBack) throws ParseException;

    /**
     * 分页查找借书记录
     * @param map
     * @return
     */
    List<LendBack> selectLendReturnRecordByUserId(Map<String,Object> map) throws ParseException;

    /**
     * 查询借书总条数
     * @param map
     * @return
     */
    int getTotalRecord(Map<String,Object> map);
}
