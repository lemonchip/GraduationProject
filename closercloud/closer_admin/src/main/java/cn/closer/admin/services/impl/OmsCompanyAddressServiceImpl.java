package cn.closer.admin.services.impl;


import cn.closer.admin.beans.OmsCompanyAddress;
import cn.closer.admin.beans.OmsCompanyAddressExample;
import cn.closer.admin.dao.OmsCompanyAddressMapper;
import cn.closer.admin.services.OmsCompanyAddressService;
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
    private OmsCompanyAddressMapper companyAddressMapper;
    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
