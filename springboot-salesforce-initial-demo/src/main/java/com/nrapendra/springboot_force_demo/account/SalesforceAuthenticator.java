package com.nrapendra.springboot_force_demo.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

import static com.nrapendra.springboot_force_demo.account.AppUtil.*;

@Slf4j
public class SalesforceAuthenticator {

    private static SalesforceAuthenticator salesforceAuthenticator = null;
    public static String accessToken;
    public static String instanceUrl;

    private SalesforceAuthenticator(MultiValueMap<String, String> params) {

        try {
            URI uri = new URI(APP_URL);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Map> response = restTemplate.postForEntity(uri, request, Map.class);

            Map<String, String> responseBody = response.getBody();

            assert responseBody != null;
            accessToken = responseBody.get(ACCESS_TOKEN);
            instanceUrl = responseBody.get(INSTANCE_URL);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public static SalesforceAuthenticator getSalesforceToken(MultiValueMap<String, String> params) {
        try {
            if (salesforceAuthenticator == null) {
                salesforceAuthenticator = new SalesforceAuthenticator(params);
                return salesforceAuthenticator;
            } else {
                return salesforceAuthenticator;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return salesforceAuthenticator;
    }
}
