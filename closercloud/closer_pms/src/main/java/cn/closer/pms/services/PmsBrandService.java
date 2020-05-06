package cn.closer.pms.services;

import cn.closer.pms.beans.PmsBrand;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName PmsBrandService.java
 * @Description TODO
 * @createTime 2020年04月14日 11:58:00
 */
public interface PmsBrandService {

    int saveBrandService(PmsBrand pmsBrand);

    PmsBrand getPmsBrandById(String id);

    int deletePmsBrandById(String id);

    int deletePmsBrandByName(String name);

    PmsBrand getPmsBrandByName(String name);



}
