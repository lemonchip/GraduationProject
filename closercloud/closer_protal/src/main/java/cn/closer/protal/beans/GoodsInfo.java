package cn.closer.protal.beans;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName GoodsInfo.java
 * @Description TODO
 * @createTime 2020年05月05日 13:00:00
 */
public class GoodsInfo {

    private Long id ;
    private String name ;
    private String brandName ;
    private BigDecimal Price ;
    private String pics ;
    private String categoryName ;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
