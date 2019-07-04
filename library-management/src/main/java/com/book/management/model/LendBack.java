package com.book.management.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LendBack {
    private Integer id;

    private Integer bookId;

    private Long userId;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date lendDate;

    private Integer shouldLendDays;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date shouldReturnDate;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date returnDate;

    private Integer isDamage;

    private String damageDegree;

    private String note;

    /**
     * 用户
     */
    private User user;

    /**
     * 图书信息
     */
    private BookInfo bookInfo;

    /**
     * 延期天数
     */
    private Integer extendedDays;

    /**
     * 图书名称
     */
    private String bookNames;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Integer getShouldLendDays() {
        return shouldLendDays;
    }

    public void setShouldLendDays(Integer shouldLendDays) {
        this.shouldLendDays = shouldLendDays;
    }

    public Date getShouldReturnDate() {
        return shouldReturnDate;
    }

    public void setShouldReturnDate(Date shouldReturnDate) {
        this.shouldReturnDate = shouldReturnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getIsDamage() {
        return isDamage;
    }

    public void setIsDamage(Integer isDamage) {
        this.isDamage = isDamage;
    }

    public String getDamageDegree() {
        return damageDegree;
    }

    public void setDamageDegree(String damageDegree) {
        this.damageDegree = damageDegree == null ? null : damageDegree.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public Integer getExtendedDays() {
        return extendedDays;
    }

    public void setExtendedDays(Integer extendedDays) {
        this.extendedDays = extendedDays;
    }

    public String getBookNames() {
        return bookNames;
    }

    public void setBookNames(String bookNames) {
        this.bookNames = bookNames;
    }
}