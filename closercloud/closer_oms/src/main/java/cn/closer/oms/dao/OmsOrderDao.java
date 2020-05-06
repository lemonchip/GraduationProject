package cn.closer.oms.dao;

import cn.closer.oms.beans.OmsOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName OmsOrderDao.java
 * @Description TODO
 * @createTime 2020年04月13日 13:02:00
 */
@Mapper
@Component
public interface OmsOrderDao extends BaseMapper<OmsOrder> {

    IPage<OmsOrder> selectPageVo(Page<OmsOrder> page, Integer state);

}
