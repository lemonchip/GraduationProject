package cn.closer.pms.dao;

import cn.closer.pms.beans.PmsProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Component;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName PmsProductDao.java
 * @Description TODO
 * @createTime 2020年04月13日 12:51:00
 */
@Component
public interface PmsProductDao extends BaseMapper<PmsProduct> {

    IPage<PmsProduct> selectPageVo(Page<PmsProduct> page, Integer state);

}
