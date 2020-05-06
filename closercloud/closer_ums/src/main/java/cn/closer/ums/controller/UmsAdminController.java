package cn.closer.ums.controller;

import cn.closer.ums.beans.UmsAdmin;
import cn.closer.ums.services.UmsAdminService;
import entity.CommonResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UmsAdminController.java
 * @Description TODO
 * @createTime 2020年04月10日 14:42:00
 */

@Api(description = "管理员用户操作接口")
@RestController
@RequestMapping("/admin")
public class UmsAdminController {


    @Autowired
    private JwtUtil jwtUtil ;

    @Autowired
    private UmsAdminService umsAdminService ;


    @ApiOperation(value = "获取UmsAdmin", notes="通过id获取UmsAdmin")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result getUserById(@PathVariable String id){

        return new Result(true,StatusCode.OK,"成功",umsAdminService.getUmsAdminById(id)) ;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result signIn(@RequestBody UmsAdmin umsAdmin){
        System.out.println("username:"+umsAdmin.getUsername());
        System.out.println("password:"+umsAdmin.getPassword());

        //获取验证结果
        Map<String,Object> map = umsAdminService.login(umsAdmin.getUsername(),umsAdmin.getPassword());

        if (map != null ){

            //生成令牌
            String token = jwtUtil.createJWT((String) map.get("id"),(String)map.get("username"),"user");

            map.put("token",token);


            return new Result(true,StatusCode.OK,"登录成功",map);
        }else {
            return new Result(false,StatusCode.LOGINERROR,"用户名或密码错误");
        }
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result register(@RequestBody UmsAdmin umsAdmin){

        umsAdmin = umsAdminService.register(umsAdmin) ;

        if(umsAdmin != null){
            return new Result(true,StatusCode.OK,"登录成功",umsAdmin);
        }else {
            return new Result(false,StatusCode.LOGINERROR,"不可用");
        }
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminInfo() {
//        if(principal==null){
//            return CommonResult.unauthorized(null);
//        }
//        String username = principal.getName();
 //       UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
        Map<String,Integer> map = new HashMap();
        map.put("id",1) ;
        map.put("parentId",0);

        List<Map<String, Integer>> menus = new ArrayList<>();

        menus.add(map) ;

        Map<String, Object> data = new HashMap<>();
        data.put("username", "test");
        data.put("roles", new String[]{"TEST"});
        data.put("menus",menus);
        data.put("icon", "icon");
        return CommonResult.success(data);
    }
}
