package cn.closer.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName EurekaServer.java
 * @Description TODO
 * @createTime 2020年03月10日 18:22:00
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {
    public static void main(String[] args) {

        SpringApplication.run(EurekaServer.class);

    }
}
