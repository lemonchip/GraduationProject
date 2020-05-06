package cn.closer.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hekaichuan
 * @version 1.0.0
 * @ClassName RabbitMqApplication.java
 * @Description TODO
 * @createTime 2020年03月09日 13:25:00
 */
@SpringBootApplication
@EnableEurekaClient
public class RabbitMqApplication {

    public static void main(String[] args) {

        SpringApplication.run(RabbitMqApplication.class) ;
    }
}
