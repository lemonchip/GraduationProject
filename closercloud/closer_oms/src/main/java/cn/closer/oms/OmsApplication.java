package cn.closer.oms;

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
 * @ClassName OmsApplication.java
 * @Description TODO
 * @createTime 2020年04月09日 12:42:00
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@EnableCaching
@MapperScan(basePackages = {"cn.closer.oms.dao"}) //扫描DAO
public class OmsApplication {
    public static void main(String[] args) {

        SpringApplication.run(OmsApplication.class) ;
    }

    @Bean
    public IdWorker idWorker(){

        return new IdWorker(1,1) ;
    }

}
