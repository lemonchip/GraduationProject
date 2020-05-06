package cn.closer.space.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UserInfo.java
 * @Description TODO
 * @createTime 2020年03月08日 12:09:00
 */
@TableName("space_user_info")
public class UserInfo {

    @TableId(type = IdType.INPUT)
    private String id ;

    private String interest ;

    private String personality ;

    private int fanscount ;

    private int followcount ;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public int getFanscount() {
        return fanscount;
    }

    public void setFanscount(int fanscount) {
        this.fanscount = fanscount;
    }

    public int getFollowcount() {
        return followcount;
    }

    public void setFollowcount(int followcount) {
        this.followcount = followcount;
    }
}
