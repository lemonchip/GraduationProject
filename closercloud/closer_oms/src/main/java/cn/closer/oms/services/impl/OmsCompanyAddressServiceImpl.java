package cn.closer.oms.services.impl;


import cn.closer.oms.beans.OmsCompanyAddress;
import cn.closer.oms.beans.OmsOrder;
import cn.closer.oms.dao.OmsCompanyAddressDao;
import cn.closer.oms.services.OmsCompanyAddressService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理Service实现类
 * Created by macro on 2018/10/18.
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressDao omsCompanyAddressDao;
    @Override
    public IPage<OmsCompanyAddress> list(Page<OmsCompanyAddress> page) {
        QueryWrapper<OmsCompanyAddress> queryWrapper = new QueryWrapper() ;
        queryWrapper.eq("1",1) ;

        return omsCompanyAddressDao.selectPage(page,queryWrapper);
    }

}
