package cn.closer.ums.services;

import cn.closer.ums.beans.UmsAdmin;
import cn.closer.ums.dto.UmsAdminParam;

import java.util.Map;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UmsAdminService.java
 * @Description TODO
 * @createTime 2020年04月10日 14:30:00
 */
public interface UmsAdminService {


    UmsAdmin getUmsAdminById(String id) ;

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    Map<String,Object> login(String username, String password);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdmin umsAdmin);

    /**
     * 修改指定用户信息
     */
    int update(Long id, UmsAdmin admin);

    /**
     * 删除指定用户
     */
    int delete(Long id);


}
