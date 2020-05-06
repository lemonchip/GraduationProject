package cn.closer.space;


import cn.closer.space.beans.User;
import cn.closer.space.beans.UserSimpleInfo;
import cn.closer.space.dao.UserSimpleInfoDao;
import cn.closer.space.services.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Random;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2020年03月07日 16:15:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    UserService userService ;
    @Autowired
    UserSimpleInfoDao userSimpleInfoDao ;

    @Autowired
    private RabbitTemplate rabbitTemplate ;

    @Autowired
    private RedisTemplate redisTemplate ;

    @org.junit.Test
    public void randomTest() {
       String i = RandomStringUtils.random(6);
       String s = RandomStringUtils.random(6,"ABCDEFGHIGKLMNOPQRSTUVWXYZ1234567890");
       System.out.println(i);
        System.out.println(s);
    }
    @org.junit.Test
    public void rabbitmq(){

        rabbitTemplate
         .convertAndSend("closerTopic","closer.space.checkcode.email","主题");
    }

    @org.junit.Test
    public void redis(){
        redisTemplate.opsForValue().set("name","hello");
    }

    public static final int START = 10000000;   //定义范围开始数字

    public static final int END = 99999999; //定义范围结束数字

    @org.junit.Test
    public void RTest(){
        long i = 1235859987482415104L ;

        //创建Random类对象
        Random random = new Random();

        //产生随机数
        int number = random.nextInt(END - START + 1) + START;
        //return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
         i   =   number & (i >>> 16);
         System.out.println(i);
    }
    @org.junit.Test
    public void userTest(){
        User user = new User();
        user.setEmail("7777@qq.com");
        user.setPassword("123456");
        user.setClosername("明凯");
        user.setUsername("max");
        userService.saveUser(user) ;
    }

    @org.junit.Test
    public void userTestAvatar(){
       UserSimpleInfo userSimpleInfo = userService.getuserSimpleById("1255744047658700800");
       userSimpleInfo.getAvatar();
       System.out.println(userSimpleInfo.getAvatar());
        System.out.println("userSimpleInfoDao:"+userSimpleInfoDao.getById("1255744047658700800").getAvatar());

    }
}
