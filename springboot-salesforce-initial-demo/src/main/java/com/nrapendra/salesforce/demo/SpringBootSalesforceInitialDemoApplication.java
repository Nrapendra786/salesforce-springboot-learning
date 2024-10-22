package com.nrapendra.salesforce.demo;

import com.nrapendra.salesforce.demo.account.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class SpringBootSalesforceInitialDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSalesforceInitialDemoApplication.class, args);
    }

}