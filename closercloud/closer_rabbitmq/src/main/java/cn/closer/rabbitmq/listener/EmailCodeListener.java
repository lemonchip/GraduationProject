package cn.closer.rabbitmq.listener;

import cn.closer.rabbitmq.services.MailService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName EmailCodeListener.java
 * @Description 邮件监听类
 * @createTime 2020年03月09日 13:38:00
 */
@Component
@RabbitListener(queues = "emailcheckcode")
public class EmailCodeListener {

    @Autowired
    private RabbitTemplate rabbitTemplate ;

    @Autowired
    private MailService mailService ;


    @RabbitHandler
    public void executeEmailCheckCode(Map<String,String> map) throws Exception{
        /**
         * @title executeEmailCheckCode
         * @description
         * @author hekaichuan
         * @param [map]
         * @updateTime 2020/3/9 0009 14:18
         * @throws
         */

//        if(map instanceof HashMap) {
//            Map<String,String>  mapN = (HashMap<String,String>)map ;
            System.out.println(map.getClass()+"类型");
            System.out.println(map.get("email"));
            System.out.println(map.get("tittle"));
            System.out.println(map.get("message"));
            //发送邮件
        try {
            mailService.sendSimpleMail(map.get("email"), map.get("tittle"), map.get("message"));

        }catch (Exception e){
            e.printStackTrace();
            Object o = rabbitTemplate.receiveAndConvert("emailcheckcode") ;
            System.out.println(o);
            throw new Exception(mailExceptionHandler(e.getMessage()));
        }
//        finally {
//            Object o = rabbitTemplate.receiveAndConvert("emailcheckcode") ;
//            System.out.println(o);
//        }

//        }else {
//            System.out.println(map.getClass()+"类型");
//            System.out.println("类型出错");
//        }
    }

    /**
     * 明确错误异常
     * */
    private String mailExceptionHandler(String errorMessage){

        if(StringUtils.isEmpty(errorMessage)){
            return errorMessage;
        }
        if(errorMessage.contains("Invalid Addresses")){
            return "邮箱地址无效，邮件服务器未找到该邮件地址，请核实！";
        }
        return errorMessage;
    }

}
