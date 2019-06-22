package com.book.management.service.impl;

import com.book.management.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("mailService")
@Component
public class MailServiceImpl implements MailService {

    private static Logger log = LoggerFactory.getLogger(MailServiceImpl.class);

    /**
     * 源邮件名
     */
    @Value("${mail.fromMail.addr}")
    private String from;

    /**
     * 引入JavaMailSender对象
     */
    @Resource
    private JavaMailSender mailSender;

    @Override
    public void sendPasswordMail(String to, String subject, String content) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        try {
            mailSender.send(simpleMailMessage);
            log.info("简单邮件发送成功!");
        } catch (MailException e) {
            log.error("发送简单邮件时发生异常！" + e);
        }
    }
}
