package com.book.management.service;

public interface MailService {

    /**
     * 发送简单邮件
     * @param to 发送到
     * @param subject 邮件标题
     * @param content 邮件内容
     */
    void sendPasswordMail(String to, String subject, String content);
}
