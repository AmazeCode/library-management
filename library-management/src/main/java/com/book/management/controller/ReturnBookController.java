package com.book.management.controller;

import com.book.management.annotation.LoginRequired;
import com.book.management.common.Result;
import com.book.management.model.BookInfo;
import com.book.management.model.LendBack;
import com.book.management.service.BookInfoService;
import com.book.management.service.ReturnBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

/**
 * 图书归还Controller
 */
@Controller
@RequestMapping("/return")
public class ReturnBookController {

    @Autowired
    private ReturnBookService returnBookService;

    @Autowired
    private BookInfoService bookInfoService;

    /**
     * 查询图书和用户信息
     * @param bookId
     * @return
     * @throws ParseException
     */
    @PostMapping("/bookInfoAndUserByBookId")
    @LoginRequired
    @ResponseBody
    public Result selectBookInfoAndUserByBookId(Integer bookId) throws ParseException {

        List<LendBack> lendReturnLists = returnBookService.selectBookInfoAndUserByBookId(bookId);
        if (lendReturnLists.size() == 0) {
            return Result.fail("记录不存在");
        } else {
            return Result.success(lendReturnLists);
        }
    }

    /**
     * 归还图书
     * @param lendBack
     * @return
     * @throws ParseException
     */
    @PostMapping("/returnBook")
    @LoginRequired
    @ResponseBody
    public Result returnBook(LendBack lendBack) throws ParseException {
        int i = returnBookService.returnBook(lendBack);
        //更新图书状态为正常
        BookInfo bookInfo = new BookInfo();
        bookInfo.setId(lendBack.getBookId());
        bookInfo.setBookState(0);
        bookInfoService.updateBookInfo(bookInfo);
        if (i > 0) {
            return Result.success(i, "还书成功");
        } else {
            return Result.fail("还书失败");
        }
    }
}
