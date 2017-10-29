package org.family.service;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author 王洪悦.{javayue@yeah.net}
 * @create 2017-10-29 下午7:29
 */
public interface MailService {

    /**
     * 发送Email服务
     *
     * @param content 内容
     * @param to      接受者
     * @param subject 主题
     * @return
     */
    Boolean sendEmail(String content, String to, String subject);

    /**
     * 发送 HTML - Email 服务
     *
     * @param content 内容
     * @param to      接受者
     * @param subject 主题
     * @return
     */
    Boolean sendHtmlEmail(String content, String to, String subject);

    /**
     * 发送正文中有静态资源（图片）的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param rscPath   物理路径
     * @param rscId     contentID
     * @return
     */
    Boolean sendStaticResourceEmail(String to, String subject, String content, String rscPath, String rscId);

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath  文件路径
     * @return
     */
    Boolean sendAttachmentsMail(String to, String subject, String content, String filePath);
}
