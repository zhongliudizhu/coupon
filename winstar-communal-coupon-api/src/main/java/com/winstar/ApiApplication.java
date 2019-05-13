package com.winstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by zl on 2019/5/13
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApiApplication.class);
        application.addListeners(new ApplicationPidFileWriter("winstar-communal-coupon-api.pid"));
        application.run(args);
    }

}
