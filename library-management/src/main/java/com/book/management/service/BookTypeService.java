package com.book.management.service;

import com.book.management.model.BookInfo;
import com.book.management.model.BookType;

import java.util.List;

public interface BookTypeService {

    /**
     * 获取图书类型
     * @param bookTypeId 图书类型id
     * @return
     */
    List<BookType>  selectBookTypeListByBookTypeId(Integer bookTypeId);

    /**
     * 查询所有图书分类
     * @return
     */
    List<BookType> queryAllBookType();

    /**
     * 新增图书分类
     * @param bookType
     * @return
     */
    int saveBookType(BookType bookType);

    /**
     * 更新图书分类
     * @param bookType
     * @return
     */
    int updateBookType(BookType bookType);

    /**
     * 删除图书分类
     * @param id
     * @return
     */
    int deleteBookType(Integer id);
}
