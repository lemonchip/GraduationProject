package cn.closer.space.config;

import cn.closer.space.interceptor.SpaceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName InterceptorConfig.java
 * @Description TODO
 * @createTime 2020年03月10日 11:23:00
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private SpaceInterceptor spaceInterceptor ;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(spaceInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("**/sign_in/**","**/sign_up/**");

    }
}
