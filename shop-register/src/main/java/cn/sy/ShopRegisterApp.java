package cn.sy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ShopRegisterApp {
    public static void main(String[] args) {
        SpringApplication.run(ShopRegisterApp.class,args);
    }
}
