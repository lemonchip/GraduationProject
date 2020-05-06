package cn.closer.admin.client;

import cn.closer.admin.beans.UmsAdmin;
import cn.closer.admin.config.MultipartSupportConfig;
import entity.CommonResult;
import entity.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UmsAdminClient.java
 * @Description TODO
 * @createTime 2020年04月16日 13:05:00
 */
@FeignClient(value = "closer-ums",configuration = MultipartSupportConfig.class)
public interface UmsAdminClient {

    @ApiOperation(value = "获取UmsAdmin", notes="通过id获取UmsAdmin")
    @RequestMapping(value = "admin/{id}",method = RequestMethod.GET)
    public Result getUserById(@PathVariable(value = "id") String id) ;

    @RequestMapping(value = "admin/login",method = RequestMethod.POST)
    public Result signIn(@RequestBody UmsAdmin umsAdmin) ;

    @RequestMapping(value = "admin/register",method = RequestMethod.POST)
    public Result register(@RequestBody UmsAdmin umsAdmin) ;

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "admin/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminInfo() ;
}
