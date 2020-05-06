package cn.closer.protal.beans;

import java.math.BigDecimal;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName HomeFlash.java
 * @Description TODO
 * @createTime 2020年05月02日 14:47:00
 */
public class HomeFlash {

    private Long productId ;
    private String name ;
    private String pic ;
    private BigDecimal price ;
    private BigDecimal flashPromotionPrice ;
    private int flashPromotionCount ;
    private int flashPromotionLimit ;
    private Long flashPromotionId ;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getFlashPromotionPrice() {
        return flashPromotionPrice;
    }

    public void setFlashPromotionPrice(BigDecimal flashPromotionPrice) {
        this.flashPromotionPrice = flashPromotionPrice;
    }

    public int getFlashPromotionCount() {
        return flashPromotionCount;
    }

    public void setFlashPromotionCount(int flashPromotionCount) {
        this.flashPromotionCount = flashPromotionCount;
    }

    public int getFlashPromotionLimit() {
        return flashPromotionLimit;
    }

    public void setFlashPromotionLimit(int flashPromotionLimit) {
        this.flashPromotionLimit = flashPromotionLimit;
    }

    public Long getFlashPromotionId() {
        return flashPromotionId;
    }

    public void setFlashPromotionId(Long flashPromotionId) {
        this.flashPromotionId = flashPromotionId;
    }
}
