package cn.closer.admin.services;



import cn.closer.admin.beans.OmsCompanyAddress;

import java.util.List;

/**
 * 收货地址管Service
 * Created by macro on 2018/10/18.
 */
public interface OmsCompanyAddressService {
    /**
     * 获取全部收货地址
     */
    List<OmsCompanyAddress> list();
}
