package cn.closer.oms.services.impl;


import cn.closer.oms.beans.OmsOrderSetting;
import cn.closer.oms.dao.OmsOrderSettingDao;
import cn.closer.oms.services.OmsOrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单设置管理Service实现类
 * Created by macro on 2018/10/16.
 */
@Service
public class OmsOrderSettingServiceImpl implements OmsOrderSettingService {
    @Autowired
    private OmsOrderSettingDao orderSettingMapper;

    @Override
    public OmsOrderSetting getItem(String id) {
        return orderSettingMapper.selectById(id);
    }

    @Override
    public int update(String  id, OmsOrderSetting orderSetting) {

        orderSetting.setId(id);

        return orderSettingMapper.updateById(orderSetting);
    }
}
