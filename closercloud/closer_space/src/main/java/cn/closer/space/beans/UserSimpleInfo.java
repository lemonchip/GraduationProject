package cn.closer.space.beans;

import java.io.Serializable;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UserSimpleInfo.java
 * @Description TODO
 * @createTime 2020年03月09日 14:31:00
 */

public class UserSimpleInfo implements Serializable {

    private String id ;

    private String closername ;

    private String avatar ;

    private int sex ;

    private String personality ;

    private int fanscount ;


    public String getUserId() {
        return id;
    }

    public void setUserId(String userId) {
        this.id = userId;
    }

    public String getClosername() {
        return closername;
    }

    public void setClosername(String closername) {
        this.closername = closername;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
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




}
