package cn.closer.fastDFS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName FastDFSApplication.java
 * @Description TODO
 * @createTime 2020年03月12日 16:24:00
 */
@SpringBootApplication
@EnableEurekaClient
public class FastDFSApplication {


    public static void main(String[] args) {

        SpringApplication.run(FastDFSApplication.class,args);

    }
}
