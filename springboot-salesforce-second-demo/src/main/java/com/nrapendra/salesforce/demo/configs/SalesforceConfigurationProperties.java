package com.nrapendra.salesforce.demo.configs;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration("salesforceConfigurationProperties")
@ConfigurationProperties(prefix = "salesforce")
public class SalesforceConfigurationProperties {
    @NotNull
    @Value("${salesforce.username}")
    private String username;

    @NotNull
    @Value("${salesforce.password}")
    private String password;

    @NotNull
    @Value("${salesforce.client_id}")
    private String consumerKey;

    @NotNull
    @Value("${salesforce.client_secret}")
    private String consumerSecret;
}
