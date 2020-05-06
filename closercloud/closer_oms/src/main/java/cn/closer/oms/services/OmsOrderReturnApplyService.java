package cn.closer.oms.services;



import cn.closer.oms.beans.OmsOrderReturnApply;
import cn.closer.oms.dto.OmsReturnApplyQueryParam;
import cn.closer.oms.dto.OmsUpdateStatusParam;

import java.util.List;

/**
 * 退货申请管理Service
 * Created by macro on 2018/10/18.
 */
public interface OmsOrderReturnApplyService {
    /**
     * 分页查询申请
     */
   // List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量删除申请
     */
    int delete(String id);

    /**
     * 修改申请状态
     */
    int updateStatus(String id, OmsUpdateStatusParam statusParam);

    /**
     * 获取指定申请详情
     */
    OmsOrderReturnApply getItem(String id);
}
