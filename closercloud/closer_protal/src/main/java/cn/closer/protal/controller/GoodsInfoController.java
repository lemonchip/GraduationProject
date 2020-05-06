package cn.closer.protal.controller;

import cn.closer.protal.beans.ProductColour;
import cn.closer.protal.beans.Product_Specs;
import cn.closer.protal.service.PmsPRoductService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName GoodsInfoController.java
 * @Description TODO
 * @createTime 2020年05月05日 13:26:00
 */
@RestController
@RequestMapping(value = "/goods")
public class GoodsInfoController {

    @Autowired
    private PmsPRoductService pmsPRoductService ;

    @RequestMapping(value = "/goodsInfo",method = RequestMethod.GET)
    public Result getHomeAdvertiseOn(@RequestParam("productID") Long id){

        return new Result(true,StatusCode.OK,"成功",pmsPRoductService.getGoodsInfoById(id)) ;

    }
    @RequestMapping(value = "/goodsInfo/specs",method = RequestMethod.GET)
    public Result getProductSpecsById(@RequestParam("productID") Long id){
        List<List<Product_Specs>> S = new ArrayList<>() ;
        List<Product_Specs> productSpecs = pmsPRoductService.getProductSpecsById(id);
        List<Product_Specs> productSpecsTemp ;
        for (int i = 0 ;i < productSpecs.size();i+=3){


            if(i+3 < productSpecs.size()){

                productSpecsTemp = productSpecs.subList(i,i+3) ;

            }else {

                productSpecsTemp = productSpecs.subList(i,productSpecs.size()) ;
            }



            S.add(productSpecsTemp) ;
        }

        return new Result(true,StatusCode.OK,"成功",S) ;

    }
    @RequestMapping(value = "/goodsInfo/colour",method = RequestMethod.GET)
    public Result getProductColourById(@RequestParam("productID") Long id){

        List<List<ProductColour>> P = new ArrayList<>() ;
        List<ProductColour> productColour = pmsPRoductService.getProductColourById(id);
        List<ProductColour> temp = new ArrayList<>() ;
        for (int i = 0 ;i < productColour.size();i+=3){


            if(i+3 < productColour.size()){

                temp = productColour.subList(i,i+3) ;

            }else {

                temp = productColour.subList(i,productColour.size()) ;
            }



            P.add(temp) ;
        }

        return new Result(true,StatusCode.OK,"成功",P) ;

    }
}
