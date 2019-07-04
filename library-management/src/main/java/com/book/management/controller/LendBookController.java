package com.book.management.controller;

import com.book.management.annotation.LoginRequired;
import com.book.management.common.DataGridDataSource;
import com.book.management.common.PageBean;
import com.book.management.common.Result;
import com.book.management.model.BookInfo;
import com.book.management.model.LendBack;
import com.book.management.model.User;
import com.book.management.service.BookInfoService;
import com.book.management.service.LendBookService;
import com.book.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lend")
public class LendBookController {

    @Autowired
    private LendBookService lendBookService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookInfoService bookInfoService;

    @PostMapping("/lendBook")
    @ResponseBody
    @LoginRequired
    public Result lendBook(LendBack lendBack)throws ParseException {
        User user = userService.findUserByUserId(lendBack.getUserId());
        if (user == null) {
            return Result.fail("用户不存在");
        }
        if (user.getState() == 0) {
            return Result.fail("用户已被禁用,无法借阅");
        }
        BookInfo info = bookInfoService.selectBookInfoById(lendBack.getBookId());
        if (info == null) {
            return Result.fail("图书不存在");
        }
        if (info.getBookState() == 1) {
            return Result.fail("图书已被借出,无法借阅");
        }
        int i = lendBookService.lendBook(lendBack);

        //更新图书状态为借出
        BookInfo bookInfo = new BookInfo();
        bookInfo.setId(lendBack.getBookId());
        bookInfo.setBookState(1);
        bookInfoService.updateBookInfo(bookInfo);
        if (i > 0) {
            return Result.success(i, "借阅成功");
        } else {
            return Result.fail("借阅失败");
        }
    }

    /**
     * 查询图书详情
     * @param id
     * @return
     */
    @PostMapping("/userInfo")
    @LoginRequired
    @ResponseBody
    public Result getBookInfo(Integer id){
        return Result.success(bookInfoService.selectBookInfoById(id));
    }

    @PostMapping("/lendreturnrecord")
    @LoginRequired
    @ResponseBody
    public DataGridDataSource<LendBack> selectLendReturnRecordByUserId(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                                       @RequestParam(value = "rows", required = false, defaultValue = "5") Integer size,
                                                                       HttpSession session) throws ParseException {

        User currentUser = (User) session.getAttribute("user");
        PageBean pageBean = new PageBean(page, size);
        Map<String, Object> map = new HashMap<>();
        map.put("userId", currentUser.getId());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<LendBack> lendReturnLists = lendBookService.selectLendReturnRecordByUserId(map);
        int totalRecord = lendBookService.getTotalRecord(map);
        DataGridDataSource<LendBack> list = new DataGridDataSource<>();
        list.setTotal(totalRecord);
        list.setRows(lendReturnLists);
        return list;
    }

}
