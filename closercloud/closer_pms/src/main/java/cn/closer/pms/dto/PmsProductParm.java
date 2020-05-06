package cn.closer.pms.dto;

import cn.closer.pms.beans.PmsProduct;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName PmsProductParm.java
 * @Description TODO
 * @createTime 2020年04月13日 18:45:00
 */
public class PmsProductParm extends PmsProduct {


    @ApiModelProperty(value = "上架状态：0->下架；1->上架")
    private Integer publishStatus;

    @ApiModelProperty(value = "新品状态:0->不是新品；1->新品")
    private Integer newStatus;

    @ApiModelProperty(value = "推荐状态；0->不推荐；1->推荐")
    private Integer recommandStatus;

    private BigDecimal price;

    @ApiModelProperty(value = "副标题")
    private String subTitle;

    @ApiModelProperty(value = "库存")
    private Integer stock;

    @ApiModelProperty(value = "是否为预告商品：0->不是；1->是")
    private Integer previewStatus;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "商品分类名称")
    private String productCategoryName;

    @ApiModelProperty(value = "商品描述")
    private String description;

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    public Integer getRecommandStatus() {
        return recommandStatus;
    }

    public void setRecommandStatus(Integer recommandStatus) {
        this.recommandStatus = recommandStatus;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPreviewStatus() {
        return previewStatus;
    }

    public void setPreviewStatus(Integer previewStatus) {
        this.previewStatus = previewStatus;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PmsProductParm{" +
                "publishStatus=" + publishStatus +
                ", newStatus=" + newStatus +
                ", recommandStatus=" + recommandStatus +
                ", price=" + price +
                ", subTitle='" + subTitle + '\'' +
                ", stock=" + stock +
                ", previewStatus=" + previewStatus +
                ", brandName='" + brandName + '\'' +
                ", productCategoryName='" + productCategoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
