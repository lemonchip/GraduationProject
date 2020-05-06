package cn.closer.protal.dao;

import cn.closer.protal.beans.GoodsInfo;
import org.apache.ibatis.annotations.*;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName GoodsInfoDao.java
 * @Description TODO
 * @createTime 2020年05月05日 13:04:00
 */
@Mapper
public interface GoodsInfoDao {

    @Select(value = "SELECT id,name,price,album_pics,product_category_name,brand_name FROM pms_product WHERE id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "album_pics", property = "pics"),
            @Result(column = "price", property = "price"),
            @Result(column = "product_category_name", property = "categoryName"),
            @Result(column = "brand_name", property = "brandName")
            })
    public GoodsInfo getGoodsInfoById(@Param(value = "id")Long id);
}
