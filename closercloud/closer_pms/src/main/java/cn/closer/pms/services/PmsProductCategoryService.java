package cn.closer.pms.services;

import cn.closer.pms.beans.PmsProductCategory;

import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName PmsProductCategoryService.java
 * @Description TODO
 * @createTime 2020年04月14日 12:18:00
 */
public interface PmsProductCategoryService {

    int savePmsProductCategory(PmsProductCategory pmsProductCategory);

    int deletePmsProductCategoryById(String id) ;

    int deletePmsProductCategoryByName(String name) ;

    PmsProductCategory getPmsProductCategoryById(String id) ;

    List<PmsProductCategory> getPmsProductCategoryAll() ;

    List<PmsProductCategory> getNavPmsProductCategorys() ;

}
