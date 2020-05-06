package cn.closer.pms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName PmsApplication.java
 * @Description TODO
 * @createTime 2020年04月09日 12:45:00
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@EnableCaching
@MapperScan(basePackages = {"cn.closer.pms.dao"}) //扫描DAO
public class PmsApplication {

    public static void main(String[] args) {

        SpringApplication.run(PmsApplication.class) ;
    }

    @Bean
    public IdWorker idWorker(){

        return new IdWorker(1,1) ;
    }

}
