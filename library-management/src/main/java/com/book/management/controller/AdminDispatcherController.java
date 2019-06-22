package com.book.management.controller;

import com.book.management.annotation.LoginRequired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 转发器Controller
 */
@Controller
public class AdminDispatcherController {
    /**
     * 登录页面
     * @return
     */
    @GetMapping("/")
    public String login() {
        return "redirect:login.jsp";
    }

    /**
     * 登出
     * @param session
     * @return
     */
    @GetMapping("/logout")
    @LoginRequired
    public String logout(HttpSession session) {
        //session初始化
        session.invalidate();
        return "redirect:login.jsp";
    }

    /**
     * 首页
     * @return
     */
    @GetMapping("/admin/index")
    @LoginRequired
    public String admin() {
        return "admin/index";
    }

    /**
     * 用户页面
     * @return
     */
    @GetMapping("/admin/user")
    @LoginRequired
    public String adminUser() {
        return "admin/user";
    }

    /**
     * 角色
     * @return
     */
    @GetMapping("/admin/role")
    @LoginRequired
    public String adminRole() {
        return "admin/role";
    }

    /**
     * 权限
     * @return
     */
    @GetMapping("/admin/permission")
    @LoginRequired
    public String adminPermission() {
        return "admin/permission";
    }

    /**
     * 图书类型
     * @return
     */
    @GetMapping("/admin/booktype")
    @LoginRequired
    public String adminBookType() {
        return "admin/booktype";
    }

    /**
     * 图书信息
     * @return
     */
    @GetMapping("/admin/bookinfo")
    @LoginRequired
    public String adminBookInfo() {
        return "admin/bookinfo";
    }

    /**
     * 图书借出
     * @return
     */
    @GetMapping("/admin/booklend")
    @LoginRequired
    public String adminBookLend() {
        return "admin/booklend";
    }

    /**
     * 图书归还
     * @return
     */
    @GetMapping("/admin/bookreturn")
    @LoginRequired
    public String adminBookReturn() {
        return "admin/bookreturn";
    }

    /**
     * 图书查询
     * @return
     */
    @GetMapping("/admin/booksearch")
    @LoginRequired
    public String adminBookSearch() {
        return "admin/booksearch";
    }

    /**
     * 图书出借记录
     * @return
     */
    @GetMapping("/admin/lendrecord")
    @LoginRequired
    public String adminLendRecord() {
        return "admin/lendrecord";
    }
}
