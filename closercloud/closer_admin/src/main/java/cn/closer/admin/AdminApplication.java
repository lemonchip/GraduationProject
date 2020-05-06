package cn.closer.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import util.IdWorker;
import util.JwtUtil;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName AdminApplication.java
 * @Description TODO
 * @createTime 2020年04月16日 12:55:00
 */
@ComponentScan(basePackages = {"cn.closer.*"})
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@EnableCaching
public class AdminApplication {

    public static void main(String[] args) {

        SpringApplication.run(AdminApplication.class) ;
    }

    @Bean
    public IdWorker idWorker(){

        return new IdWorker(1,1) ;
    }

    @Bean
    public BCryptPasswordEncoder encoder(){

        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtUtil jwtUtil(){

        return new JwtUtil();
    }
}
