package cn.closer.protal.dao;

import cn.closer.protal.beans.HomeAdvertise;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName HomeAdvertiseDao.java
 * @Description TODO
 * @createTime 2020年05月02日 10:16:00
 */
@Mapper
public interface HomeAdvertiseDao extends BaseMapper<HomeAdvertise> {

        @Select(value = "SELECT id,name,type,pic,status,url,note FROM sms_home_advertise WHERE status = 1")
        public List<HomeAdvertise> getHomeAdvertiseByStatusOn() ;

}
