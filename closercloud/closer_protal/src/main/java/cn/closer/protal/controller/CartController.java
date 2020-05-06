package cn.closer.protal.controller;

import cn.closer.protal.beans.Cart;
import cn.closer.protal.beans.GoodListItemInfo;
import cn.closer.protal.service.CartService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName CartController.java
 * @Description TODO
 * @createTime 2020年05月05日 18:50:00
 */
@RestController
@RequestMapping(value = "cart")
public class CartController {

    @Autowired
    private CartService cartService ;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result addCart(@RequestBody Cart cart){

        return new Result(true,StatusCode.OK,"成功",cartService.insterCart(cart)) ;

    }

    @RequestMapping(value = "/userCart",method = RequestMethod.GET)
    public Result getGoodListByCategory(@RequestParam("userId") String userId, @RequestParam("page")int page,@RequestParam("size")int size){
        IPage<Cart> page1 = new Page<>(page,size) ;

        return new Result(true,StatusCode.OK,"成功",cartService.getCartsByUserId(page1,userId)) ;
    }
}
