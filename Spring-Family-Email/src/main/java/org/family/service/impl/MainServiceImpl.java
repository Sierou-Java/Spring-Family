package org.family.service.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.family.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 发送邮箱服务
 *
 * @author 王洪悦.{javayue@yeah.net}
 * @create 2017-10-29 下午7:31
 */
@Service
public class MainServiceImpl implements MailService{

    private static final Logger logger = LoggerFactory.getLogger(MainServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    /**
     * 发送Email服务
     *
     * @param content  内容
     * @param to       接受者
     * @param subject  主题
     * @return
     */
    @Override
    public Boolean sendEmail(String content, String to, String subject) {
        Boolean flag = false;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            flag = true;
            logger.info("简单邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送简单邮件时发生异常！", e);
        }
        return flag;
    }

    /**
     * 发送模板Email服务
     *
     * @param content 内容
     * @param to      接受者
     * @param subject 主题
     * @return
     */
    @Override
    public Boolean sendHtmlEmail(String content, String to, String subject) {
        Boolean flag = false;
        MimeMessage message = mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
            flag = true;
            logger.info("html邮件发送成功");
        } catch (MessagingException e) {
            logger.error("发送html邮件时发生异常！", e);
        }
        return flag;
    }

    /**
     * 发送正文中有静态资源（图片）的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     * @return
     */
    @Override
    public Boolean sendStaticResourceEmail(String to, String subject, String content, String rscPath, String rscId) {
        Boolean flag = false;
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);

            mailSender.send(message);
            logger.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送嵌入静态资源的邮件时发生异常！", e);
        }
        return flag;
    }

    @Override
    public Boolean sendAttachmentsMail(String to, String subject, String content, String filePath){
        Boolean flag = false;
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            mailSender.send(message);
            logger.info("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送带附件的邮件时发生异常！", e);
        }
        return flag;
    }
}
