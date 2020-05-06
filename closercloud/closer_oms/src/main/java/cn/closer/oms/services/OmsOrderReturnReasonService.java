package cn.closer.oms.services;



import cn.closer.oms.beans.OmsOrderReturnReason;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 订单原因管理Service
 * Created by macro on 2018/10/17.
 */
public interface OmsOrderReturnReasonService {
    /**
     * 添加订单原因
     */
    int create(OmsOrderReturnReason returnReason);

    /**
     * 修改退货原因
     */
    int update(String id, OmsOrderReturnReason returnReason);

    /**
     * 批量删除退货原因
     */
    int delete(List<String> ids);

    /**
     * 分页获取退货原因
     */
    IPage<OmsOrderReturnReason> list(Page<OmsOrderReturnReason> page);

//    /**
//     * 批量修改退货原因状态
//     */
//    int updateStatus(List<String> ids, Integer status);

    /**
     * 获取单个退货原因详情信息
     */
    OmsOrderReturnReason getItem(String id);
}
