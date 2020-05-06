package cn.closer.space.controller;


import cn.closer.space.beans.User;
import cn.closer.space.beans.UserSimpleInfo;
import cn.closer.space.client.ImageClient;
import cn.closer.space.services.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
@Api(description = "用户操作接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService ;

    @Autowired
    private HttpServletRequest request ;

    @Autowired
    private ImageClient imageClient ;

    @ApiOperation(value = "获取otp", notes="通过手机号获取OTP验证码")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result getUserById(@PathVariable String id){

        return new Result(true,StatusCode.OK,"成功",userService.getById(id)) ;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result addUser(@RequestBody User user){

        System.out.println(user.getUsername());
        System.out.println(user.getClosername());
        String id = userService.saveUser(user) ;
        return new Result(true,StatusCode.OK,"成功",id);
    }

    @RequestMapping(value = "/name/{name}",method = RequestMethod.GET)
    public Result getUserByUserName(@PathVariable String name){

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("username","closername","avatar","sex","mobile","email");
        queryWrapper.eq("username",name);


        Object o = userService.getOne(queryWrapper);
        return new Result(true,StatusCode.OK,"成功",o) ;
    }

    @RequestMapping(value = "/user_simple/{id}",method = RequestMethod.GET)
    public Result getUserSimpleById(@PathVariable String id){

        //授权不通过返回空
//        String uid = (String) request.getAttribute("user_id") ;
//
//        System.out.println("token_id:"+uid);
//
//        if (uid==null||"".equals(uid)){
//            return new Result(true,StatusCode.OK,"成功",null) ;
//        }

       UserSimpleInfo u = userService.getuserSimpleById(id);
       if (u!= null){
           return new Result(true,StatusCode.OK,"成功",u) ;
       }else {
           return new Result(false,StatusCode.ERROR,"没有此用户") ;
       }
    }

    @RequestMapping(value = "/avatar",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result saveAvatar(@RequestPart(value = "file") MultipartFile file,
                             @RequestParam(value = "user_id") String id ){

        String result = imageClient.singleFileUpload(file) ;
        System.out.println("avatar:"+result);
        if(result != null){

            userService.UpdateAvatar(id,result);
            return new Result(true,StatusCode.OK,"成功") ;
        }else {

            return new Result(false,StatusCode.ERROR,"失败") ;
        }


    }
}
