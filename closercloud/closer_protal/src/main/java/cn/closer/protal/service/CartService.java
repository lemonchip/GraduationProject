package cn.closer.protal.service;

import cn.closer.protal.beans.Cart;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName CartService.java
 * @Description TODO
 * @createTime 2020年05月05日 18:40:00
 */
public interface CartService {

    int insterCart(Cart cart) ;

    IPage<Cart> getCartsByUserId(IPage<Cart> page, String userId) ;
}
