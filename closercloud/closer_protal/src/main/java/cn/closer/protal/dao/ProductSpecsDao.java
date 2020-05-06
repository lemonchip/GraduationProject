package cn.closer.protal.dao;

import cn.closer.protal.beans.ProductColour;
import cn.closer.protal.beans.Product_Specs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName ProductSpecsDao.java
 * @Description TODO
 * @createTime 2020年05月05日 15:19:00
 */
@Mapper
public interface ProductSpecsDao extends BaseMapper<Product_Specs> {


    @Select(value = "SELECT product_id,value FROM pms_product_specs WHERE product_id = #{id}")
    @Results({
            @Result(column = "product_id", property = "productId"),
            @Result(column = "value", property = "value")
    })
    public List<Product_Specs> getProductSpecsById(@Param("id")Long id) ;
}
