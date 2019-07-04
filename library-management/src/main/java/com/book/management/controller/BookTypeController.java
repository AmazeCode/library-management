package com.book.management.controller;

import com.book.management.annotation.LoginRequired;
import com.book.management.common.DataGridDataSource;
import com.book.management.common.Result;
import com.book.management.model.BookType;
import com.book.management.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bookType")
public class BookTypeController {

    @Autowired
    private BookTypeService bookTypeService;

    /**
     * 加载图书分类数据
     * @return
     */
    @PostMapping("/loadAllBookTypeData")
    @LoginRequired
    @ResponseBody
    public Object loadAllBookTypeData(){
        List<Object> bookTypes = new ArrayList<Object>();
        List<BookType> bookTypeList = bookTypeService.queryAllBookType();
        Map<Integer, BookType> bookTypeMap = new HashMap<>();
        for (BookType bookType : bookTypeList) {
            bookTypeMap.put(bookType.getId(), bookType);
        }
        for (BookType bookType : bookTypeList) {
            BookType child = bookType;
            if (child.getTypeParentId() == null) {
                bookTypes.add(bookType);
            } else {
                BookType parent = bookTypeMap.get(child.getTypeParentId());
                parent.getChildren().add(child);
            }
        }
        return bookTypes;
    }

    /**
     * 分页查询图书分类列表
     * @param id
     * @return
     */
    @PostMapping("/listByBookTypeId")
    @LoginRequired
    @ResponseBody
    public DataGridDataSource<BookType> getBookTypeList(@RequestParam(defaultValue = "0") Integer id){

        List<BookType> bookTypeList = bookTypeService.selectBookTypeListByBookTypeId(id);
        DataGridDataSource<BookType> dataGridDataSource = new DataGridDataSource<>();
        dataGridDataSource.setRows(bookTypeList);
        dataGridDataSource.setTotal(bookTypeList.size());
        return dataGridDataSource;
    }

    /**
     * 保存图书分类
     * @return
     */
    @PostMapping("/save")
    @LoginRequired
    @ResponseBody
    public Result saveBookType(BookType bookType){
        int count = bookTypeService.saveBookType(bookType);
        if (count > 0){
            return Result.success(count,"保存成功!");
        }else{
            return Result.fail("删除成功!");
        }
    }

    /**
     * 更新图书类型
     * @param bookType
     * @return
     */
    @PutMapping("/update")
    @LoginRequired
    @ResponseBody
    public Result updateBookType(BookType bookType){
        int count = bookTypeService.updateBookType(bookType);
        if(count > 0){
            return Result.success(count,"更新成功!");
        }else{
            return Result.fail("更新失败!");
        }
    }

    /**
     * 删除图书失败
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    @LoginRequired
    @ResponseBody
    public Result deleteBookType(Integer id){
        int count = bookTypeService.deleteBookType(id);
        if(count > 0){
            return Result.success(count,"删除成功!");
        }else{
            return Result.fail("删除失败!");
        }
    }
}
