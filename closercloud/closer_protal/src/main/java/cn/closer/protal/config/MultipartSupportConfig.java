package cn.closer.protal.config;

import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName MultipartSupportConfig.java
 * @Description TODO
 * @createTime 2020年03月13日 13:29:00
 */
@Configuration
public class MultipartSupportConfig {



    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public SpringFormEncoder feignEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }

}
