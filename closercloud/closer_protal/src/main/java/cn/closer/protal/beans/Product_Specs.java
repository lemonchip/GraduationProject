package cn.closer.protal.beans;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName Product_Specs.java
 * @Description TODO
 * @createTime 2020年05月05日 15:14:00
 */
public class Product_Specs {
    private Long productId;
    private String value ;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
