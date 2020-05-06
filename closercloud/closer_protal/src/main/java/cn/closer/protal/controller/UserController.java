package cn.closer.protal.controller;

import cn.closer.protal.beans.UserLogin;
import cn.closer.protal.client.UserClient;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年04月30日 13:16:00
 */
@RestController
public class UserController {

    @Autowired
    UserClient userClient ;

    @RequestMapping(value = "/sign_in",method = RequestMethod.POST)
    public Result signIn(@RequestBody UserLogin userLogin){
      return   userClient.signIn(userLogin) ;
    }
}
