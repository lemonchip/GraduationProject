package cn.closer.oms.services.impl;

import cn.closer.oms.beans.OmsOrder;
import cn.closer.oms.beans.OmsOrderOperateHistory;
import cn.closer.oms.dao.OmsOrderDao;
import cn.closer.oms.dao.OmsOrderOperateHistoryDao;
import cn.closer.oms.dto.OmsOrderDeliveryParam;
import cn.closer.oms.dto.OmsOrderQueryParam;
import cn.closer.oms.dto.OmsReceiverInfoParam;
import cn.closer.oms.services.OmsOrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单管理Service实现类
 * Created by macro on 2018/10/11.
 */
@Service
public class OmsOrderServiceImpl implements OmsOrderService {

    @Autowired
    private OmsOrderDao orderOrderDao;

    @Autowired
    private OmsOrderDao orderDao;

    @Autowired
    private OmsOrderOperateHistoryDao orderOperateHistoryDao;

    @Override
    public IPage<OmsOrder> list(Page<OmsOrder> page, Integer state) {

     return  orderOrderDao.selectPageVo(page,state) ;

    }

    @Override
    public int delivery(List<OmsOrderDeliveryParam> deliveryParamList) {
        //批量发货
        int count = 1 ;//orderDao.delivery(deliveryParamList);
//        //添加操作记录
//        List<OmsOrderOperateHistory> operateHistoryList = deliveryParamList.stream()
//                .map(omsOrderDeliveryParam -> {
//                    OmsOrderOperateHistory history = new OmsOrderOperateHistory();
//                    history.setOrderId(omsOrderDeliveryParam.getOrderId());
//                    history.setCreateTime(new Date());
//                    history.setOperateMan("后台管理员");
//                    history.setOrderStatus(2);
//                    history.setNote("完成发货");
//                    return history;
//                }).collect(Collectors.toList());
//        orderOperateHistoryDao.insertList(operateHistoryList);
        return count;
    }

    @Override
    public int close(List<Long> ids, String note) {
        /*
        OmsOrder record = new OmsOrder();
        record.setStatus(4);
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        int count = orderMapper.updateByExampleSelective(record, example);
        List<OmsOrderOperateHistory> historyList = ids.stream().map(orderId -> {
            OmsOrderOperateHistory history = new OmsOrderOperateHistory();
            history.setOrderId(orderId);
            history.setCreateTime(new Date());
            history.setOperateMan("后台管理员");
            history.setOrderStatus(4);
            history.setNote("订单关闭:"+note);
            return history;
        }).collect(Collectors.toList());
        orderOperateHistoryDao.insertList(historyList);
        */
        return 1;
    }

    @Override
    public int delete(List<Long> ids) {
//        OmsOrder record = new OmsOrder();
//        record.setDeleteStatus(1);
//        OmsOrderExample example = new OmsOrderExample();
//        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        return  1 ;//orderMapper.updateByExampleSelective(record, example);
    }

    @Override
    public OmsOrder detail(String id) {
        return orderOrderDao.selectById(id);
    }

    @Override
    public int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam) {
        OmsOrder order = new OmsOrder();
        order.setId(receiverInfoParam.getOrderId());
        order.setReceiverName(receiverInfoParam.getReceiverName());
        order.setReceiverPhone(receiverInfoParam.getReceiverPhone());
        order.setReceiverPostCode(receiverInfoParam.getReceiverPostCode());
        order.setReceiverDetailAddress(receiverInfoParam.getReceiverDetailAddress());
        order.setReceiverProvince(receiverInfoParam.getReceiverProvince());
        order.setReceiverCity(receiverInfoParam.getReceiverCity());
        order.setReceiverRegion(receiverInfoParam.getReceiverRegion());
        order.setModifyTime(new Date());

        QueryWrapper<OmsOrder> queryWrapper = new QueryWrapper() ;
        queryWrapper.eq("id",receiverInfoParam.getOrderId()) ;

        int count = orderOrderDao.update(order,queryWrapper);
        //插入操作记录
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(receiverInfoParam.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(receiverInfoParam.getStatus());
        history.setNote("修改收货人信息");
        orderOperateHistoryDao.insert(history);
        return count;
    }


    @Override
    public int updateNote(String id, String note, Integer status) {
        OmsOrder order = new OmsOrder();
        QueryWrapper<OmsOrder> queryWrapper = new QueryWrapper() ;
        queryWrapper.eq("id",id) ;

        order.setNote(note);
        order.setModifyTime(new Date());
        int count = orderOrderDao.update(order,queryWrapper);

        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(id);
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(status);
        history.setNote("修改备注信息："+note);
        orderOperateHistoryDao.insert(history);
        return count;
    }
}
