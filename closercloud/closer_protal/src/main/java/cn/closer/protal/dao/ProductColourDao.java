package cn.closer.protal.dao;

import cn.closer.protal.beans.ProductColour;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName ProductColourDao.java
 * @Description TODO
 * @createTime 2020年05月05日 15:19:00
 */
@Mapper
public interface ProductColourDao extends BaseMapper<ProductColour> {

    @Select(value = "SELECT product_id,value,img FROM pms_product_colour WHERE product_id = #{id}")
    @Results({
            @Result(column = "product_id", property = "productId"),
            @Result(column = "value", property = "value"),
            @Result(column = "img", property = "img"),
            })
    public List<ProductColour> getProductColourById(@Param("id")Long id) ;
}
