package com.nrapendra.springboot_force_demo.account;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "salesforce")
public record AppConfig(String username, String password,
                        String clientId, String clientSecret,
                        String redirectUri, String grantType) {

}
