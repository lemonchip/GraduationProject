package cn.closer.protal.service.impl;

import cn.closer.protal.beans.GoodListItemInfo;
import cn.closer.protal.beans.GoodsInfo;
import cn.closer.protal.beans.ProductColour;
import cn.closer.protal.beans.Product_Specs;
import cn.closer.protal.dao.GoodListDao;
import cn.closer.protal.dao.GoodsInfoDao;
import cn.closer.protal.dao.ProductColourDao;
import cn.closer.protal.dao.ProductSpecsDao;
import cn.closer.protal.service.PmsPRoductService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName PmsPRoductServiceImpl.java
 * @Description TODO
 * @createTime 2020年05月01日 11:08:00
 */
@Service
@Transactional
public class PmsPRoductServiceImpl implements PmsPRoductService {

    @Autowired
    private GoodListDao goodListDao ;

    @Autowired
    private GoodsInfoDao goodsInfoDao ;

    @Autowired
    private ProductColourDao productColourDao ;

    @Autowired
    private ProductSpecsDao productSpecsDao ;

    @Override
    public List<GoodListItemInfo> getGoodList(String Category) {

        return  goodListDao.getGoodListByCategory(Category);

    }

    @Override
    public IPage<GoodListItemInfo> getGoodPage(IPage<GoodListItemInfo> page , String Category) {


        return goodListDao.getGoodPageByCategory(page , Category);
    }

    @Override
    public Map<String, Object> getGoodsInfoById(Long id) {

        GoodsInfo goodsInfo = goodsInfoDao.getGoodsInfoById(id) ;

        String[]  pics = null ;
        String pic = goodsInfo.getPics() ;

        if(pic != null){
             pics = pic.split(",");
        }

        Map<String,Object> map = new HashMap<>();
        map.put("productId",goodsInfo.getId());
        map.put("pics",pics);
        map.put("Price",goodsInfo.getPrice());
        map.put("categoryName",goodsInfo.getCategoryName());
        map.put("name",goodsInfo.getName());
        map.put("brandName",goodsInfo.getBrandName());

        return map;
    }

    @Override
    public List<ProductColour> getProductColourById(Long id) {

//        List<List<ProductColour>> P = null ;
//        List<ProductColour> productColour = productColourDao.getProductColourById(id);
//        List<ProductColour> temp = new ArrayList<>() ;
//            for (int i = 0 ;i < productColour.size();i+=3){
//
//                if(i+3 >= productColour.size()){
//                    temp = productColour.subList(i,productColour.size()) ;
//                }
//                temp = productColour.subList(i,i+3) ;
//
//                P.add(temp) ;
//            }




        return productColourDao.getProductColourById(id);

    }

    @Override
    public List<Product_Specs> getProductSpecsById(Long id) {

        return productSpecsDao.getProductSpecsById(id);
    }
}
