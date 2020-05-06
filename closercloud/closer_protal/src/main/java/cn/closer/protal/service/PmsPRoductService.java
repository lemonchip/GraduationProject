package cn.closer.protal.service;

import cn.closer.protal.beans.GoodListItemInfo;
import cn.closer.protal.beans.ProductColour;
import cn.closer.protal.beans.Product_Specs;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Map;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName PmsPRoductService.java
 * @Description TODO
 * @createTime 2020年05月01日 11:08:00
 */
public interface PmsPRoductService {

    List<GoodListItemInfo> getGoodList(String Category) ;

    IPage<GoodListItemInfo> getGoodPage(IPage<GoodListItemInfo> page, String Category) ;

    Map<String,Object> getGoodsInfoById(Long id);

    List<ProductColour> getProductColourById(Long id) ;

    List<Product_Specs> getProductSpecsById(Long id) ;
}
