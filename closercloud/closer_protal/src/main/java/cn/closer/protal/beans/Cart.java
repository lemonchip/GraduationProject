package cn.closer.protal.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName Cart.java
 * @Description TODO
 * @createTime 2020年05月05日 18:34:00
 */
@TableName("ums_member_cart")
public class Cart {

    @TableId(type = IdType.AUTO)
    private Long id ;

    private Long productId ;

    private String productBrand ;
    private String spaceUserId ;
    private String productName ;
    private String productImg ;
    private String productSpecs ;
    private String productColour ;
    private int count ;
    private int status ;
    private BigDecimal price ;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSpaceUserId() {
        return spaceUserId;
    }

    public void setSpaceUserId(String spaceUserId) {
        this.spaceUserId = spaceUserId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSpecs() {
        return productSpecs;
    }

    public void setProductSpecs(String productSpecs) {
        this.productSpecs = productSpecs;
    }

    public String getProductColour() {
        return productColour;
    }

    public void setProductColour(String productColour) {
        this.productColour = productColour;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
