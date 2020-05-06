package cn.closer.oms.services.impl;


import cn.closer.oms.beans.OmsOrderReturnApply;
import cn.closer.oms.beans.OmsOrderReturnReason;
import cn.closer.oms.dao.OmsOrderReturnReasonDao;
import cn.closer.oms.services.OmsOrderReturnReasonService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 订单原因管理Service实现类
 * Created by macro on 2018/10/17.
 */
@Service
public class OmsOrderReturnReasonServiceImpl implements OmsOrderReturnReasonService {
    @Autowired
    private OmsOrderReturnReasonDao returnReasonMapper;
    @Override
    public int create(OmsOrderReturnReason returnReason) {
        returnReason.setCreateTime(new Date());
        return returnReasonMapper.insert(returnReason);
    }

    @Override
    public int update(String id, OmsOrderReturnReason returnReason) {
        returnReason.setId(id);
        return returnReasonMapper.updateById(returnReason);
    }

    @Override
    public int delete(List<String> ids) {
        //OmsOrderReturnReasonExample example = new OmsOrderReturnReasonExample();
       // example.createCriteria().andIdIn(ids);
        return returnReasonMapper.deleteBatchIds(ids);
    }

    @Override
    public IPage<OmsOrderReturnReason> list(Page<OmsOrderReturnReason> page) {
        QueryWrapper<OmsOrderReturnReason> queryWrapper = new QueryWrapper() ;
        queryWrapper.eq("1",1) ;
        return returnReasonMapper.selectPage(page,queryWrapper);
    }



    @Override
    public OmsOrderReturnReason getItem(String id) {
        return returnReasonMapper.selectById(id);
    }
}
