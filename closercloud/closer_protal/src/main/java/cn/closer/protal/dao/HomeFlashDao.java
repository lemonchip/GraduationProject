package cn.closer.protal.dao;

import cn.closer.protal.beans.HomeFlash;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName HomeFlashDao.java
 * @Description TODO
 * @createTime 2020年05月02日 12:57:00
 */
@Mapper
public interface HomeFlashDao {

    @Select("SELECT a.id product_id,a.name,a.pic,a.price,b.flash_promotion_price,b.flash_promotion_count,b.flash_promotion_limit,b.flash_promotion_id FROM pms_product a\n" +
            "RIGHT OUTER JOIN (SELECT product_id,flash_promotion_price,flash_promotion_count,flash_promotion_limit,flash_promotion_id FROM sms_flash_promotion_product_relation\n" +
            "WHERE flash_promotion_id in (SELECT id FROM sms_flash_promotion WHERE status = 1)) b\n" +
            "ON a.id = b.product_id")
    @Results({
            @Result(column = "product_id", property = "productId"),
            @Result(column = "name", property = "name"),
            @Result(column = "pic", property = "pic"),
            @Result(column = "price", property = "price"),
            @Result(column = "flash_promotion_price", property = "flashPromotionPrice"),
            @Result(column = "flash_promotion_count", property = "flashPromotionCount"),
            @Result(column = "flash_promotion_limit", property = "flashPromotionLimit"),
            @Result(column = "flash_promotion_id", property = "flashPromotionId")
            })
    public List<HomeFlash> getHomeFlashs() ;

}
