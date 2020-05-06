package cn.closer.pms.services.impl;

import cn.closer.pms.beans.PmsProduct;
import cn.closer.pms.dao.*;
import cn.closer.pms.dto.PmsProductParm;
import cn.closer.pms.services.PmsProductService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName PmsProductServiceImpl.java
 * @Description TODO
 * @createTime 2020年04月13日 13:12:00
 */
@Service
@Transactional
public class PmsProductServiceImpl implements PmsProductService {


    @Autowired
    private PmsProductDao pmsProductDao ;

    @Autowired
    private PmsCommentDao pmsCommentDao ;

    @Autowired
    private PmsProductAttributeDao pmsProductAttributeDao ;

    @Autowired
    private PmsProductCategoryDao pmsProductCategoryDao ;

    @Autowired
    private PmsBrandDao brandDao ;

    @Autowired
    private IdWorker idWorker ;

    @Override
    public int create(PmsProductParm pmsProductParm) {

        PmsProduct pmsProduct  ;

        pmsProduct = pmsProductParm ;

        String id = "PP"+idWorker.nextId() ;
        pmsProduct.setId(id);

        String brandId = brandDao.getIdByName(pmsProduct.getBrandName()) ;
        pmsProduct.setBrandId(brandId);


        String pmsProductCategorId = pmsProductCategoryDao.getIdByName(pmsProduct.getProductCategoryName()) ;
        pmsProduct.setProductCategoryId(pmsProductCategorId);

        return pmsProductDao.insert(pmsProduct);
    }


    @Override
    public int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
        return 0;
    }

    @Override
    public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
        return 0;
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        return 0;
    }

    @Override
    public int updateNewStatus(List<Long> ids, Integer newStatus) {
        return 0;
    }

    @Override
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        return 0;
    }

    @Override
    public PmsProduct getPmsProductById(String id) {

        return  pmsProductDao.selectById(id);
    }

    @Override
    public IPage<PmsProduct> selectPmsProductPage(Page<PmsProduct> page, Integer state) {

        return pmsProductDao.selectPageVo(page,state);
    }
}
