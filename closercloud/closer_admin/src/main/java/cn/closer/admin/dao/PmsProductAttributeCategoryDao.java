package cn.closer.admin.dao;



import cn.closer.admin.dto.PmsProductAttributeCategoryItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 自定义商品属性分类Dao
 * Created by macro on 2018/5/24.
 */
@Mapper
public interface PmsProductAttributeCategoryDao {
    /**
     * 获取包含属性的商品属性分类
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
