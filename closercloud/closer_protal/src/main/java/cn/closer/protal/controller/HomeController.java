package cn.closer.protal.controller;

import cn.closer.protal.service.HomeService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName HomeController.java
 * @Description TODO
 * @createTime 2020年05月02日 10:11:00
 */
@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private HomeService homeService ;

    @RequestMapping(value = "/homeAdvertise",method = RequestMethod.GET)
    public Result getHomeAdvertiseOn(){

        return new Result(true,StatusCode.OK,"成功",homeService.getHomeAdvertiseOn()) ;
    }

    @RequestMapping(value = "/homeFlash",method = RequestMethod.GET)
    public Result getHomeFlashOn(){

        return new Result(true,StatusCode.OK,"成功",homeService.getHomeFlash()) ;
    }
}
