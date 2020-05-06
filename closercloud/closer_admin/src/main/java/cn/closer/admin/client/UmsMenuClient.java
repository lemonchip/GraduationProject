package cn.closer.admin.client;

import cn.closer.admin.beans.UmsMenu;
import cn.closer.admin.config.MultipartSupportConfig;
import cn.closer.admin.dto.CommonPage;
import cn.closer.admin.dto.UmsMenuNode;
import entity.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UmsMenuClient.java
 * @Description TODO
 * @createTime 2020年04月16日 13:45:00
 */
@FeignClient(value = "closer-ums",configuration = MultipartSupportConfig.class)
public interface UmsMenuClient {

    @ApiOperation("添加后台菜单")
    @RequestMapping(value = "/menu/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsMenu umsMenu) ;

    @ApiOperation("修改后台菜单")
    @RequestMapping(value = "/menu/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable(value = "id") Long id,
                               @RequestBody UmsMenu umsMenu) ;

    @ApiOperation("根据ID获取菜单详情")
    @RequestMapping(value = "/menu/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<UmsMenu> getItem(@PathVariable(value = "id") Long id);

    @ApiOperation("根据ID删除后台菜单")
    @RequestMapping(value = "/menu/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable(value = "id") Long id) ;

    @ApiOperation("分页查询后台菜单")
    @RequestMapping(value = "/menu/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsMenu>> list(@PathVariable(value = "parentId" ) Long parentId,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) ;

    @ApiOperation("树形结构返回所有菜单列表")
    @RequestMapping(value = "/menu/treeList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsMenuNode>> treeList() ;

    @ApiOperation("修改菜单显示状态")
    @RequestMapping(value = "/menu/updateHidden/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateHidden(@PathVariable(value = "id") Long id, @RequestParam("hidden") Integer hidden) ;



    }
