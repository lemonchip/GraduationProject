package cn.closer.protal.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName GoodListItemInfo.java
 * @Description TODO
 * @createTime 2020年05月01日 10:55:00
 */
@TableName("pms_product")
public class GoodListItemInfo {

    @TableId(type = IdType.AUTO)
    private Long id ;
    private String name ;
    private String pic ;
    private BigDecimal originalPrice ;
    private int sale ;

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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }
}
