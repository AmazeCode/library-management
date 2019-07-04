package com.book.management.service;

import com.book.management.model.LendBack;

import java.text.ParseException;
import java.util.List;

/**
 * 归还图书SEVICE
 */
public interface ReturnBookService {

    /**
     * 根据图书id查询图书及借阅者信息
     * @param bookId
     * @return
     */
    List<LendBack> selectBookInfoAndUserByBookId(Integer bookId) throws ParseException;

    /**
     * 归还图书
     * @param lendBack
     * @return
     */
    int returnBook(LendBack lendBack) throws ParseException;
}
