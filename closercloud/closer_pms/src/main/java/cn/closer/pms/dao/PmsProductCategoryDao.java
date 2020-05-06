package cn.closer.pms.dao;

import cn.closer.pms.beans.PmsProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName PmsProductCategoryDao.java
 * @Description TODO
 * @createTime 2020年04月13日 12:53:00
 */
@Component
public interface PmsProductCategoryDao extends BaseMapper<PmsProductCategory> {

    @Select("select id from pms_product_category where name = #{name}")
    String getIdByName(@Param(value = "name")String name);
}
