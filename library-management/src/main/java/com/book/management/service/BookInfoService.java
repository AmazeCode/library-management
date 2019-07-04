package com.book.management.service;

import com.book.management.model.BookInfo;

import java.util.List;
import java.util.Map;

public interface BookInfoService {
    /**
     * 获取图书集合
     * @param map
     * @return
     */
    List<BookInfo> selectBookInfoList(Map<String,Object> map);

    /**
     *
     * @param map
     * @return
     */
    int getTotalBook(Map<String,Object> map);

    /**
     * 保存图书信息
     * @param bookInfo
     * @return
     */
    int saveBookInfo(BookInfo bookInfo);

    /**
     * 更新图书信息
     * @param bookInfo
     * @return
     */
    int updateBookInfo(BookInfo bookInfo);

    /**
     * 根据图书id删除图书信息
     * @param id
     * @return
     */
    int deleteBookInfo(Integer id);

    /**
     * 根据图书id查找图书信息
     * @param id
     * @return
     */
    BookInfo selectBookInfoById(Integer id);
}
