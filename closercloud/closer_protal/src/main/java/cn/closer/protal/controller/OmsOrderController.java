package cn.closer.protal.controller;

import cn.closer.protal.beans.Cart;
import cn.closer.protal.beans.OmsOrder;
import cn.closer.protal.beans.OmsOrderItem;
import cn.closer.protal.service.CartService;
import cn.closer.protal.service.OmsOrderService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName OmsOrderController.java
 * @Description TODO
 * @createTime 2020年05月06日 15:17:00
 */
@RestController
@RequestMapping(value = "order")
public class OmsOrderController {


    @Autowired
    private OmsOrderService omsOrderService ;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result addOmsOrder(@RequestBody OmsOrder omsOrder){

        return new Result(true,StatusCode.OK,"成功",omsOrderService.create(omsOrder)) ;

    }

    @RequestMapping(value = "/addItem",method = RequestMethod.POST)
    public Result addOmsOrderItem(@RequestBody OmsOrderItem omsOrderItem){

        return new Result(true,StatusCode.OK,"成功",omsOrderService.createItem(omsOrderItem)) ;

    }
    @RequestMapping(value = "/getOrder",method = RequestMethod.GET)
    public Result getOrderItemForUser(@RequestParam("userId") String userId,@RequestParam("page")int page,@RequestParam("size")int size){
        IPage<OmsOrderItem> page1 = new Page<>(page,size) ;
        return new Result(true,StatusCode.OK,"成功",omsOrderService.getOrderItemForUser(page1,userId)) ;

    }
}

