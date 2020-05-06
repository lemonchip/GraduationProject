package cn.closer.protal.dao;

import cn.closer.protal.beans.GoodListItemInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName GoodListDao.java
 * @Description TODO
 * @createTime 2020年05月01日 11:07:00
 */
@Mapper
public interface GoodListDao extends BaseMapper<GoodListItemInfo> {

    @Select(value = "SELECT id,name,pic,original_price,sale " +
            "FROM pms_product " +
            "WHERE product_category_name = #{Category} ")
    @Results({ @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "pic", property = "pic"),
            @Result(column = "original_price", property = "originalPrice"),
            @Result(column = "sale", property = "sale")})
    public List<GoodListItemInfo> getGoodListByCategory(@Param(value = "Category")String Category) ;


    @Select(value = "SELECT id,name,pic,original_price,sale " +
            "FROM pms_product " +
            "WHERE product_category_name = #{Category} ")
    @Results({ @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "pic", property = "pic"),
            @Result(column = "original_price", property = "originalPrice"),
            @Result(column = "sale", property = "sale")})
    public IPage<GoodListItemInfo> getGoodPageByCategory(IPage<GoodListItemInfo> page, @Param(value = "Category")String Category) ;



}
