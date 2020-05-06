package cn.closer.pms.services.impl;


import cn.closer.pms.beans.PmsBrand;
import cn.closer.pms.dao.PmsBrandDao;
import cn.closer.pms.services.PmsBrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;


/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName PmsBrandServiceImpl.java
 * @Description TODO
 * @createTime 2020年04月14日 11:59:00
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {


    @Autowired
    private IdWorker idWorker ;

    @Autowired
    private PmsBrandDao pmsBrandDao ;

    @Transactional
    @Override
    public int saveBrandService(PmsBrand pmsBrand) {

        String id = "PB"+idWorker.nextId() ;

        pmsBrand.setId(id);
        pmsBrand.setProductCommentCount(0);

        return pmsBrandDao.insert(pmsBrand);

    }

    @Override
    public PmsBrand getPmsBrandById(String id) {

        return pmsBrandDao.selectById(id);

    }

    @Override
    public int deletePmsBrandById(String id) {
        return pmsBrandDao.deleteById(id);
    }

    @Override
    public int deletePmsBrandByName(String name) {
        QueryWrapper<PmsBrand> queryWrapper = new QueryWrapper() ;
        queryWrapper.eq("name",name);
        return pmsBrandDao.delete(queryWrapper) ;
    }

    @Override
    public PmsBrand getPmsBrandByName(String name) {

        QueryWrapper<PmsBrand> queryWrapper = new QueryWrapper() ;
        queryWrapper.eq("name",name);
        return pmsBrandDao.selectOne(queryWrapper);
    }
}
