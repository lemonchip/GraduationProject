package cn.closer.pms.dao;

import cn.closer.pms.beans.PmsBrand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName PmsBrandDao.java
 * @Description TODO
 * @createTime 2020年04月13日 12:51:00
 */
@Component
public interface PmsBrandDao extends BaseMapper<PmsBrand> {

    @Select("select id from pms_brand where name = #{name}")
    String getIdByName(@Param(value = "name")String name);

}
