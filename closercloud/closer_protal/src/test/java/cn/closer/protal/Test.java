package cn.closer.protal;

import cn.closer.protal.beans.GoodListItemInfo;
import cn.closer.protal.service.PmsPRoductService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2020年05月01日 11:31:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private PmsPRoductService pmsPRoductService ;

    @org.junit.Test
    public void goodListTset(){

        List<GoodListItemInfo> list = pmsPRoductService.getGoodList("手机数码") ;

        for (GoodListItemInfo good : list){
            System.out.println(good.getName());
            System.out.println(good.getOriginalPrice());
            System.out.println(good.getPic());
            System.out.println(good.getSale());
        }
    }

    @org.junit.Test
    public void goodPageTest(){

        IPage<GoodListItemInfo> page = new Page<>(1, 7);
        page  = pmsPRoductService.getGoodPage(page,"手机数码") ;
        List<GoodListItemInfo> list = page.getRecords() ;

        for (GoodListItemInfo goods : list){
            System.out.println(goods.getName());
            System.out.println(goods.getOriginalPrice());
            System.out.println(goods.getPic());
            System.out.println(goods.getSale());
        }
    }
}
