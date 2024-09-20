package com.nrapendra.springboot_force_demo;

import com.nrapendra.springboot_force_demo.account.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class SpringbootSalesforceInitialDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSalesforceInitialDemoApplication.class, args);
	}

}
