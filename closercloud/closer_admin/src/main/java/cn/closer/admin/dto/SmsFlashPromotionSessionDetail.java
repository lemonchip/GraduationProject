package cn.closer.admin.dto;

import cn.closer.admin.beans.SmsFlashPromotionSession;

import lombok.Getter;
import lombok.Setter;

/**
 * 包含商品数量的场次信息
 * Created by macro on 2018/11/19.
 */
public class SmsFlashPromotionSessionDetail extends SmsFlashPromotionSession {

    private Long productCount;

    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }
}
