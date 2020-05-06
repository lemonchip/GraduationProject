package cn.closer.ums.services;

import cn.closer.ums.beans.UmsMember;
import cn.closer.ums.beans.UmsMemberLoginLog;

import java.util.Map;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UmsMemberService.java
 * @Description TODO
 * @createTime 2020年04月13日 11:09:00
 */
public interface UmsMemberService {

    UmsMember getUmsMemberById(String id);

    boolean updateUmsMember(UmsMember umsMember);

    String insertUmsMember(UmsMember umsMember);

    String umsMemberSignUp(UmsMember umsMember);

    Map<String,Object> userSignIn(UmsMember umsMember);

    void setMemberLoginLog(UmsMemberLoginLog umsMemberLoginLog);

}
