package cn.closer.oms.dao;

import cn.closer.oms.beans.OmsOrderItem;
import cn.closer.oms.beans.OmsOrderOperateHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName OmsOrderOperateHistoryDao.java
 * @Description TODO
 * @createTime 2020年04月13日 13:03:00
 */
@Component
public interface OmsOrderOperateHistoryDao extends BaseMapper<OmsOrderOperateHistory> {
}
