package cn.closer.protal.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UserLogin.java
 * @Description TODO
 * @createTime 2020年03月08日 12:32:00
 */

@TableName("space_user_login")
public class UserLogin {

    @TableId(type = IdType.INPUT)
    private String userId ;

    private String username ;

    private String password ;

    private String mobile ;

    private String email ;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
