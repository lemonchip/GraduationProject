package cn.closer.admin.controller;

import cn.closer.admin.beans.UmsAdmin;
import cn.closer.admin.client.UmsAdminClient;
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
    private JwtUtil jwtUtil;

    @Autowired
    private UmsAdminClient umsAdminClient;


    @ApiOperation(value = "获取UmsAdmin", notes = "通过id获取UmsAdmin")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getUserById(@PathVariable String id) {

        return umsAdminClient.getUserById(id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result signIn(@RequestBody UmsAdmin umsAdmin) {
        System.out.println("username:" + umsAdmin.getUsername());
        System.out.println("password:" + umsAdmin.getPassword());

        return umsAdminClient.signIn(umsAdmin);

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody UmsAdmin umsAdmin) {

        return umsAdminClient.register(umsAdmin);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminInfo() {

        return umsAdminClient.getAdminInfo();
    }
}