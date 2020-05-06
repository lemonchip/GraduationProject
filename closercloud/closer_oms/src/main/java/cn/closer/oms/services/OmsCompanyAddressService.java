package cn.closer.oms.services;



import cn.closer.oms.beans.OmsCompanyAddress;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 收货地址管Service
 * Created by macro on 2018/10/18.
 */
public interface OmsCompanyAddressService {
    /**
     * 获取全部收货地址
     */
    IPage<OmsCompanyAddress> list(Page<OmsCompanyAddress> page);
}
