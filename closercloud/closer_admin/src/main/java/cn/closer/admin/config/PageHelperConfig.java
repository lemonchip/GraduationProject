package cn.closer.admin.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName PageHelperConfig.java
 * @Description TODO
 * @createTime 2020年04月15日 14:37:00
 */
@Configuration
public class PageHelperConfig {

    @Bean
    public PageHelper createPaeHelper(){
        PageHelper page= new PageHelper();
        return page;
    }
}
