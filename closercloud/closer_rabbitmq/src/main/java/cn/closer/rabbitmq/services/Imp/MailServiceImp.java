package cn.closer.rabbitmq.services.Imp;

import cn.closer.rabbitmq.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName MailServiceImp.java
 * @Description 邮箱服务
 * @createTime 2020年03月08日 19:28:00
 */
@Service
public class MailServiceImp implements MailService {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public boolean sendSimpleMail(String to, String title, String content) {
        /**
         * @title sendSimpleMail
         * @description 发送邮件
         * @author hekaichuan
         * @param [to, title, content] 收件人，标题，内容
         * @updateTime 2020/3/8 0008 20:05
         * @throws
         * @return: boolean
         */

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);
        try {
            mailSender.send(message);
        }catch (Exception e){

            e.printStackTrace();
        }finally {

            return true ;
        }


    }

}
