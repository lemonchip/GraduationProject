package cn.closer.protal.service.impl;

import cn.closer.protal.beans.Cart;
import cn.closer.protal.dao.CartDao;
import cn.closer.protal.service.CartService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName CartServiceImpl.java
 * @Description TODO
 * @createTime 2020年05月05日 18:40:00
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao ;


    @Override
    public int insterCart(Cart cart) {

        cart.setStatus(1);

        int s =  cartDao.insert(cart) ;


        return s;
    }

    @Override
    public IPage<Cart> getCartsByUserId(IPage<Cart> page, String userId) {

        return cartDao.getCartsByUserId(page,userId);

    }
}
