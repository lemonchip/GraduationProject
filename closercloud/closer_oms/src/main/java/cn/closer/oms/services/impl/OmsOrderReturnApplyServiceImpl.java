package cn.closer.oms.services.impl;


import cn.closer.oms.beans.OmsOrder;
import cn.closer.oms.beans.OmsOrderReturnApply;
import cn.closer.oms.dao.OmsOrderReturnApplyDao;
import cn.closer.oms.dto.OmsReturnApplyQueryParam;
import cn.closer.oms.dto.OmsUpdateStatusParam;
import cn.closer.oms.services.OmsOrderReturnApplyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 订单退货管理Service
 * Created by macro on 2018/10/18.
 */
@Service
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService {
    @Autowired
    private OmsOrderReturnApplyDao returnApplyDao;



    @Override
    public int delete(String id) {


        return returnApplyDao.deleteById(id);
    }

    @Override
    public int updateStatus(String id, OmsUpdateStatusParam statusParam) {
        Integer status = statusParam.getStatus();
        OmsOrderReturnApply returnApply = new OmsOrderReturnApply();
        if(status.equals(1)){
            //确认退货
            returnApply.setId(id);
            returnApply.setStatus(1);
            returnApply.setReturnAmount(statusParam.getReturnAmount());
            returnApply.setCompanyAddressId(statusParam.getCompanyAddressId());
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        }else if(status.equals(2)){
            //完成退货
            returnApply.setId(id);
            returnApply.setStatus(2);
            returnApply.setReceiveTime(new Date());
            returnApply.setReceiveMan(statusParam.getReceiveMan());
            returnApply.setReceiveNote(statusParam.getReceiveNote());
        }else if(status.equals(3)){
            //拒绝退货
            returnApply.setId(id);
            returnApply.setStatus(3);
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        }else{
            return 0;
        }

        QueryWrapper<OmsOrderReturnApply> queryWrapper = new QueryWrapper() ;
        queryWrapper.eq("id",id) ;

        return returnApplyDao.update(returnApply,queryWrapper);
    }

    @Override
    public OmsOrderReturnApply getItem(String  id) {
        return returnApplyDao.selectById(id);
    }
}
