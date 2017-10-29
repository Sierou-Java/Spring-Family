package org.family;

import org.family.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFamilyEmailApplicationTests {

    final String to = "javayue@yeah.net";
    final String content = "hello world!";
    final String subject = "subject!";

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void contextLoads() {
        Boolean flag = mailService.sendEmail(content, to, subject);
        System.out.println(flag);
    }


    @Test
    public void testThymeleaf() {
        Context context = new Context();
        context.setVariable("code", "6666");
        String emailContent = templateEngine.process("email", context);
        Boolean flag = mailService.sendHtmlEmail(emailContent, to, subject);
        System.out.println(flag);
    }


    @Test
    public void sendStaticResourceEmail() {
        String rscId = "sierou";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        System.out.println(content);
        String imgPath = "/documents/合付宝/合付宝资料/合付宝1横版无背景.png";

        mailService.sendStaticResourceEmail(to, subject, content, imgPath, rscId);
    }


    @Test
    public void sendAttachmentsMail() {
        String filePath = "/documents/合付宝/合付宝资料/合付宝1横版无背景.png";
        mailService.sendAttachmentsMail(to, subject, "有附件，请查收！", filePath);
    }
}
