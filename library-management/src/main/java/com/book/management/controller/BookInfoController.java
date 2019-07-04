package com.book.management.controller;

import com.book.management.annotation.LoginRequired;
import com.book.management.common.DataGridDataSource;
import com.book.management.common.PageBean;
import com.book.management.common.Result;
import com.book.management.model.BookInfo;
import com.book.management.model.BookType;
import com.book.management.service.BookInfoService;
import com.book.management.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  图书基本信息Controller
 */
@Controller
@RequestMapping("/bookinfo")
public class BookInfoController {

    /**
     * SERVICE
     */
    @Autowired
    private BookInfoService bookInfoService;

    /**
     * SERVICE
     */
    @Resource
    private BookTypeService bookTypeService;

    /**
     * 图书列表
     * @param bookSerial
     * @param bookName
     * @param bookAuthor
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/list")
    @LoginRequired //需要登陆验证
    @ResponseBody
    public DataGridDataSource<BookInfo> getBookList(@RequestParam(value = "bookSerial", required = false, defaultValue = "") String bookSerial,
                                                    @RequestParam(value = "bookName", required = false, defaultValue = "") String bookName,
                                                    @RequestParam(value = "bookAuthor", required = false, defaultValue = "") String bookAuthor,
                                                    @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                    @RequestParam(value = "rows", required = false, defaultValue = "10") Integer pageSize){
        PageBean pageBean = new PageBean(page,pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("start",pageBean.getStart());
        map.put("size",pageBean.getPageSize());
        //模糊条件
        map.put("bookSerial",bookSerial);
        map.put("bookName",bookName);
        map.put("bookAuthor",bookAuthor);
        //查询图书集合
        List<BookInfo> bookInfoList = bookInfoService.selectBookInfoList(map);

        //循环图书
        for(BookInfo bookInfo : bookInfoList){
            //查询图书分类型集合
            List<BookType> bookTypeList = bookTypeService.selectBookTypeListByBookTypeId(bookInfo.getBookType());
            for (BookType bookType : bookTypeList) {
                bookInfo.setBookType(bookType.getId());
            }
        }
        int totalBook = bookInfoService.getTotalBook(map);
        DataGridDataSource<BookInfo> bookInfoDataGridDataSource = new DataGridDataSource<>();
        bookInfoDataGridDataSource.setTotal(totalBook);
        bookInfoDataGridDataSource.setRows(bookInfoList);
        return bookInfoDataGridDataSource;
    }

    /**
     * 保存图书信息
     * @param bookInfo
     * @return
     */
    @PostMapping("/save")
    @LoginRequired
    @ResponseBody
    public Result saveBookInfo(BookInfo bookInfo){
        int count = bookInfoService.saveBookInfo(bookInfo);
        if (count > 0) {
            return Result.success(count, "新增成功");
        } else {
            return Result.fail("新增失败");
        }
    }

    /**
     * 修改图书信息
     * @param bookInfo
     * @return
     */
    @PutMapping("/update")
    @LoginRequired
    @ResponseBody
    public Result updateBookInfo(BookInfo bookInfo){
        int count = bookInfoService.updateBookInfo(bookInfo);
        if (count > 0) {
            return Result.success(count, "编辑成功");
        } else {
            return Result.fail("编辑失败");
        }
    }

    /**
     * 删除图书信息
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    @LoginRequired
    @ResponseBody
    public Result deleteBookInfo(Integer id){
        int count = bookInfoService.deleteBookInfo(id);
        if (count > 0){
            return Result.success(count,"删除成功!");
        }else{
            return Result.fail("删除失败!");
        }
    }

    /**
     * 查询图书详情
     * @param id
     * @return
     */
    @PostMapping("/info")
    @LoginRequired
    @ResponseBody
    public Result getBookInfo(Integer id){
        return Result.success(bookInfoService.selectBookInfoById(id));
    }

    /**
     * 图书详情
     * @param bookId
     * @return
     */
    @GetMapping("/detail")
    @LoginRequired
    @ResponseBody
    public Result bookInfoDetail(Integer bookId) {
        BookInfo bookInfos = bookInfoService.selectBookInfoById(bookId);
        if(null != bookInfos){
            List<BookType> bookTypeList = bookTypeService.selectBookTypeListByBookTypeId(bookInfos.getBookType());
            for (BookType bookType : bookTypeList) {
                bookInfos.setTypes(bookType.getTypeName());
            }
        }
        return Result.success(bookInfos);
    }
}
