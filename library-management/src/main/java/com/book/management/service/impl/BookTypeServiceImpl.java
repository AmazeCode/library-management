package com.book.management.service.impl;

import com.book.management.dao.BookTypeMapper;
import com.book.management.exception.ParamException;
import com.book.management.model.BookType;
import com.book.management.service.BookTypeService;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图书类型SERVICE
 */
@Service
@Transactional
public class BookTypeServiceImpl implements BookTypeService {

    @Resource
    private BookTypeMapper bookTypeMapper;

    @Override
    public List<BookType> selectBookTypeListByBookTypeId(Integer bookTypeId) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",bookTypeId);
        //查询图书图书类型集合
        return bookTypeMapper.selectBookTypeListByBookTypeId(map);
    }

    @Override
    public List<BookType> queryAllBookType() {
        return bookTypeMapper.queryAllBookType();
    }

    @Override
    public int saveBookType(BookType bookType) {
        if (checkBookTypeNameExist(bookType.getTypeName(), bookType.getId())) {
            throw new ParamException("分类名称已经存在");
        }
        BookType bookTypes = new BookType();
        bookTypes.setTypeName(bookType.getTypeName());
        bookTypes.setTypeParentId(bookType.getTypeParentId());
        bookTypes.setTypeNote(bookType.getTypeNote());
        return bookTypeMapper.insertSelective(bookTypes);
    }

    @Override
    public int updateBookType(BookType bookType) {
        if (checkBookTypeNameExist(bookType.getTypeName(), bookType.getId())) {
            throw new ParamException("分类名称已经存在");
        }

        BookType before = bookTypeMapper.selectByPrimaryKey(bookType.getId());
        Preconditions.checkNotNull(before, "需更新分类不存在");
        BookType bookTypes = new BookType();
        bookTypes.setId(bookType.getId());
        bookTypes.setTypeName(bookType.getTypeName());
        bookTypes.setTypeParentId(bookType.getTypeParentId());
        bookTypes.setTypeNote(bookType.getTypeNote());
        return bookTypeMapper.updateByPrimaryKeySelective(bookTypes);
    }

    @Override
    public int deleteBookType(Integer id) {
        BookType before = bookTypeMapper.selectByPrimaryKey(id);
        Preconditions.checkNotNull(before, "需删除的分类不存在");
        return bookTypeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 判断分类名称是否存在
     * @param typeName
     * @param id
     * @return
     */
    private boolean checkBookTypeNameExist(String typeName,Integer id){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("typeName",typeName);
        map.put("id",id);
        return bookTypeMapper.countByBookTypeName(map) > 0;
    }
}
