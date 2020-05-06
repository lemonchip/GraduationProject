package cn.closer.protal.service;

import cn.closer.protal.beans.Cart;
import cn.closer.protal.beans.OmsOrder;
import cn.closer.protal.beans.OmsOrderItem;
import cn.closer.protal.dto.OmsOrderResult;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName OmsOrderService.java
 * @Description TODO
 * @createTime 2020年05月06日 14:54:00
 */
public interface OmsOrderService {

    OmsOrderResult create(OmsOrder omsOrder) ;

    int createItem(OmsOrderItem omsOrderItem) ;

     IPage<OmsOrderItem> getOrderItemForUser(IPage<OmsOrderItem> page, String userId);
}
