package cn.closer.protal.dto;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName OmsOrderResult.java
 * @Description TODO
 * @createTime 2020年05月06日 15:13:00
 */
public class OmsOrderResult {

    private Long orderId ;
    private String orderSn ;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }
}
