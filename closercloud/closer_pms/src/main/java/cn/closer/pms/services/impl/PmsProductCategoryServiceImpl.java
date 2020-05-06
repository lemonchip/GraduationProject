package cn.closer.pms.services.impl;


import cn.closer.pms.beans.PmsProductCategory;

import cn.closer.pms.dao.PmsProductCategoryDao;
import cn.closer.pms.services.PmsProductCategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import util.IdWorker;

import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName PmsProductCategoryServiceImpl.java
 * @Description TODO
 * @createTime 2020年04月14日 12:18:00
 */
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {

    @Autowired
    private IdWorker idWorker ;

    @Autowired
    private PmsProductCategoryDao pmsProductCategoryDao ;


    @Override
    public int savePmsProductCategory(PmsProductCategory pmsProductCategory) {

        String id = "PPC"+idWorker.nextId() ;
        pmsProductCategory.setId(id);

        return  pmsProductCategoryDao.insert(pmsProductCategory);

    }

    @Override
    public int deletePmsProductCategoryById(String id) {
        return pmsProductCategoryDao.deleteById(id);
    }

    @Override
    public int deletePmsProductCategoryByName(String name) {

        QueryWrapper<PmsProductCategory> queryWrapper = new QueryWrapper() ;
        queryWrapper.eq("name",name);
        return pmsProductCategoryDao.delete(queryWrapper);

    }

    @Override
    public PmsProductCategory getPmsProductCategoryById(String id) {
        return pmsProductCategoryDao.selectById(id);
    }

    @Override
    public List<PmsProductCategory> getPmsProductCategoryAll() {

        QueryWrapper<PmsProductCategory> queryWrapper = new QueryWrapper() ;
        queryWrapper.eq("1",1) ;

        return pmsProductCategoryDao.selectList(queryWrapper);
    }

    @Override
    public List<PmsProductCategory> getNavPmsProductCategorys() {
        QueryWrapper<PmsProductCategory> queryWrapper = new QueryWrapper() ;
        queryWrapper.eq("nav_status",1) ;

        return pmsProductCategoryDao.selectList(queryWrapper);
    }
}
