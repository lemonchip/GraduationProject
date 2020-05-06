package cn.closer.oms.services;


import cn.closer.oms.beans.OmsOrderSetting;

/**
 * 订单设置Service
 * Created by macro on 2018/10/16.
 */
public interface OmsOrderSettingService {
    /**
     * 获取指定订单设置
     */
    OmsOrderSetting getItem(String  id);

    /**
     * 修改指定订单设置
     */
    int update(String id, OmsOrderSetting orderSetting);
}
