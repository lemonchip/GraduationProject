package cn.closer.protal.dao;

import cn.closer.protal.beans.Cart;
import cn.closer.protal.beans.GoodListItemInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.*;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName CartDao.java
 * @Description TODO
 * @createTime 2020年05月05日 18:40:00
 */
@Mapper
public interface CartDao extends BaseMapper<Cart> {

    @Select(value = "SELECT space_user_id,product_id,product_name,product_specs,product_colour,count,price,product_img,product_brand " +
            "FROM ums_member_cart " +
            "WHERE space_user_id = #{userId} " +
            "AND status = 1")
    @Results({
            @Result(column = "space_user_id", property = "spaceUserId"),
            @Result(column = "product_id", property = "productId"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "product_specs", property = "productSpecs"),
            @Result(column = "product_colour", property = "productColour"),
            @Result(column = "count", property = "count"),
            @Result(column = "price", property = "price"),
            @Result(column = "product_img", property = "productImg"),
            @Result(column = "product_brand", property = "productBrand")
    })
    public IPage<Cart> getCartsByUserId(IPage<Cart> page, @Param(value = "userId")String userId) ;
}
