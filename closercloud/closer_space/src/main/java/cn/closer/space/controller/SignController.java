package cn.closer.space.controller;

import cn.closer.space.beans.User;
import cn.closer.space.beans.UserLogin;
import cn.closer.space.beans.UserSimpleInfo;
import cn.closer.space.services.UserService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName SignController.java
 * @Description 登录注册
 * @createTime 2020年03月08日 13:02:00
 */


@RestController
public class SignController {

    @Autowired
    private UserService userService ;

    @Autowired
    private RedisTemplate redisTemplate ;

    @Autowired
    private JwtUtil jwtUtil ;

    @RequestMapping(value = "/sign_in",method = RequestMethod.POST)
    public Result signIn(@RequestBody UserLogin userLogin){

        //获取验证结果
        Map<String,Object> map = userService.userSignIn(userLogin);

        if (map != null ){

            //生成令牌
            String token = jwtUtil.createJWT((String) map.get("id"),(String)map.get("email"),"user");

            map.put("token",token);

            UserSimpleInfo userSimpleInfo = userService.getuserSimpleById((String)map.get("id"));
            map.put("user",userSimpleInfo);

            return new Result(true,StatusCode.OK,"登录成功",map);
        }else {
            return new Result(false,StatusCode.LOGINERROR,"用户名或密码错误");
        }
    }

    @RequestMapping(value = "/sign_up/{checkcode}",method = RequestMethod.POST)
    public Result signUp(@RequestBody User user,@PathVariable String checkcode){

        //从缓存中获取验证码
        String code = (String)redisTemplate.opsForValue().get("checkcode"+user.getEmail()) ;
        if(code.isEmpty()){
            return new Result(false,StatusCode.ERROR,"请先获取验证码") ;
        }
        if(!code.equals(checkcode)){
            return new Result(false,StatusCode.ERROR,"验证码错误") ;
        }

        //注册成功返回id
        String id = userService.userSignUp(user) ;
        if(id != null){
            //生成令牌
            String token = jwtUtil.createJWT(id,user.getEmail(),"user");

            Map<String,String> map = new HashMap<>();
            map.put("id",id) ;
            map.put("token",token);
            return new Result(true,StatusCode.OK,"注册成功",map) ;
        }else {
            return new Result(false,StatusCode.ERROR,"错误") ;
        }
    }

    @RequestMapping(value = "/check_code",method = RequestMethod.GET)
    public void checkCode(@RequestParam(value = "email") String email){
        //
         System.out.println(email);
         userService.sendCodeEmail(email);
    }

    @RequestMapping(value = "/check_email",method = RequestMethod.GET)
    public Result checkEmail(@RequestParam(value = "email") String email){
                System.out.println(email);

                if(userService.checkEmail(email)){
                    return new Result(true,StatusCode.OK,"可用邮箱") ;
                }else {
                    return new Result(false,StatusCode.ERROR,"邮箱已经注册，请勿重复注册") ;
                }

    }


}
