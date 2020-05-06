package cn.closer.rabbitmq.services;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName MailService.java
 * @Description TODO
 * @createTime 2020年03月08日 19:28:00
 */
public interface MailService {

    boolean sendSimpleMail(String to, String title, String content);

}
