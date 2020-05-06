package cn.closer.admin.dto;


import cn.closer.admin.beans.OmsOrder;
import cn.closer.admin.beans.OmsOrderItem;
import cn.closer.admin.beans.OmsOrderOperateHistory;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;


import java.util.List;

/**
 * 订单详情信息
 * Created by macro on 2018/10/11.
 */
public class OmsOrderDetail extends OmsOrder {

    private List<OmsOrderItem> orderItemList;

    private List<OmsOrderOperateHistory> historyList;

    public List<OmsOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public List<OmsOrderOperateHistory> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<OmsOrderOperateHistory> historyList) {
        this.historyList = historyList;
    }
}
