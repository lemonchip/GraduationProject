package cn.closer.protal.controller;

import cn.closer.protal.beans.GoodListItemInfo;
import cn.closer.protal.service.PmsPRoductService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName GoodListController.java
 * @Description TODO
 * @createTime 2020年05月01日 12:07:00
 */
@RestController
@RequestMapping(value = "/product")
public class GoodListController {

    @Autowired
    private PmsPRoductService pmsPRoductService ;

    @RequestMapping(value = "/goodList",method = RequestMethod.GET)
    public Result getGoodListByCategory(@RequestParam("category") String category, @RequestParam("page")int page){
        IPage<GoodListItemInfo> page1 = new Page<>(page,20) ;

        return new Result(true,StatusCode.OK,"成功",pmsPRoductService.getGoodPage(page1,category)) ;
    }
}
