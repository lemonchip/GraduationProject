package cn.closer.space;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import util.IdWorker;
import util.JwtUtil;

@MapperScan(basePackages = {"cn.closer.space.dao"}) //扫描DAO
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@EnableCaching
public class SpaceApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpaceApplication.class) ;
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
