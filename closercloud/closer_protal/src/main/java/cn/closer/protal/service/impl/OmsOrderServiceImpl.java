package cn.closer.protal.service.impl;

import cn.closer.protal.beans.OmsOrder;
import cn.closer.protal.beans.OmsOrderItem;
import cn.closer.protal.beans.UserLogin;
import cn.closer.protal.dao.OmsOrderDao;
import cn.closer.protal.dao.OmsOrderItemDao;
import cn.closer.protal.dto.OmsOrderResult;
import cn.closer.protal.service.OmsOrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName OmsOrderServiceImpl.java
 * @Description TODO
 * @createTime 2020年05月06日 14:55:00
 */
@Service
@Transactional
public class OmsOrderServiceImpl implements OmsOrderService {

    @Autowired
    private OmsOrderDao omsOrderDao ;

    @Autowired
    private OmsOrderItemDao omsOrderItemDao ;

    @Autowired
    private IdWorker idWorker ;

    @Override
    public OmsOrderResult create(OmsOrder omsOrder) {

        String id = idWorker.nextId()+"" ;

        String time = new SimpleDateFormat("YYYYMMddhh").format(new Date());

        Random random = new Random();
        int START = 10000000;
        int END = 99999999;
        int number = random.nextInt(END - START + 1) + START;

        String orderSn = time+number ;
        omsOrder.setOrderSn(orderSn);
        omsOrder.setCreateTime(new Date());
        omsOrder.setIdWork(id);
        System.out.println( "omsOrder" + omsOrder );
        int res = omsOrderDao.insert(omsOrder) ;

        if(res == 1){

            QueryWrapper<OmsOrder> queryWrapper = new QueryWrapper<>() ;
            queryWrapper.eq("id_work",omsOrder.getIdWork());
            queryWrapper.select("id","order_sn");
            OmsOrder omsOrderTemp = omsOrderDao.selectOne(queryWrapper) ;
            OmsOrderResult omsOrderResult = new OmsOrderResult() ;
            omsOrderResult.setOrderId(omsOrderTemp.getId());
            omsOrderResult.setOrderSn(omsOrderTemp.getOrderSn());
            return omsOrderResult;

        }else {

            return null;
        }

    }

    @Override
    public int createItem(OmsOrderItem omsOrderItem) {

        return  omsOrderItemDao.insert(omsOrderItem);
    }

    @Override
    public IPage<OmsOrderItem> getOrderItemForUser(IPage<OmsOrderItem> page, String userId) {


        QueryWrapper<OmsOrderItem> queryWrapper = new QueryWrapper<>() ;
        queryWrapper.eq("space_user_id",userId);

        return omsOrderItemDao.selectPage(page,queryWrapper);
    }


}
