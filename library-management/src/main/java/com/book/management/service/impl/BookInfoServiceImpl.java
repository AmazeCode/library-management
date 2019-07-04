package com.book.management.service.impl;

import com.book.management.dao.BookInfoMapper;
import com.book.management.model.BookInfo;
import com.book.management.service.BookInfoService;
import com.google.common.base.Preconditions;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 图书SERVICE
 */
@Service
@Transactional
public class BookInfoServiceImpl implements BookInfoService {

    /**
     * 标注接口
     */
    @Resource
    private BookInfoMapper bookInfoMapper;

    @Override
    public List<BookInfo> selectBookInfoList(Map<String, Object> map) {
        return bookInfoMapper.selectBookInfoList(map);
    }

    @Override
    public int getTotalBook(Map<String, Object> map) {
        return bookInfoMapper.getTotalBook(map);
    }

    @Override
    public int saveBookInfo(BookInfo bookInfo) {
        //创建时间
        bookInfo.setCreateTime(new Date());
        //图书状态
        bookInfo.setBookState(0);
        return bookInfoMapper.insertSelective(bookInfo);
    }

    @Override
    public int updateBookInfo(BookInfo bookInfo) {
        //修改图书时间
        bookInfo.setUpdateTime(new Date());
        return bookInfoMapper.updateByPrimaryKeySelective(bookInfo);
    }

    @Override
    public int deleteBookInfo(Integer id) {
        //根据id查找图书信息
        BookInfo bookInfo = bookInfoMapper.selectByPrimaryKey(id);
        Preconditions.checkNotNull(bookInfo,"需要删除的图书不存在!");
        return bookInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public BookInfo selectBookInfoById(Integer id) {
        BookInfo before = bookInfoMapper.selectByPrimaryKey(id);
        Preconditions.checkNotNull(before, "图书不存在");
        return bookInfoMapper.selectByPrimaryKey(id);
    }
}
