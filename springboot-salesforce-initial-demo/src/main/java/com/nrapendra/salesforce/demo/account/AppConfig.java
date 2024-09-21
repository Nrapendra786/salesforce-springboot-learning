package com.nrapendra.salesforce.demo.account;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "salesforce")
public record AppConfig(String username, String password,
                        String clientId, String clientSecret,
                        String redirectUri, String grantType) {

}
