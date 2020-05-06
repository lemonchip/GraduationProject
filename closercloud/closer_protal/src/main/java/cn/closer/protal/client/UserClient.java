package cn.closer.protal.client;

import cn.closer.protal.beans.UserLogin;
import cn.closer.protal.config.MultipartSupportConfig;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName UserClient.java
 * @Description TODO
 * @createTime 2020年04月30日 13:10:00
 */
@FeignClient(value = "closer-space",configuration = MultipartSupportConfig.class)
public interface UserClient {

    @RequestMapping(value = "/sign_in",method = RequestMethod.POST)
    public Result signIn(@RequestBody UserLogin userLogin);
}
