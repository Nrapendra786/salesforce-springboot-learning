package com.nrapendra.salesforce.demo.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

import static com.nrapendra.salesforce.demo.account.AppUtil.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class SalesforceDataService {

    private final AppConfig appConfig;

    public Map<?, ?> getSalesforceData(String query) {

        SalesforceAuthenticator salesforceAuthenticator = SalesforceAuthenticator.getSalesforceToken(getMultiValueMapHttpEntity());
        try {
            RestTemplate restTemplate = new RestTemplate();
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
            final String baseUrl = SalesforceAuthenticator.instanceUrl + "/services/data/v52.0/query/?q="
                    + encodedQuery;
            URI uri = new URI(baseUrl);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.add(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", SalesforceAuthenticator.accessToken));

            HttpEntity<?> request = new HttpEntity<Object>(headers);

            ResponseEntity<Map> response = null;
            try {
                response = restTemplate.exchange(uri, HttpMethod.GET, request, Map.class);
            } catch (HttpClientErrorException e) {
                log.error(e.getMessage());
            }
            assert response != null;
            return response.getBody();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Collections.EMPTY_MAP;
    }

    private MultiValueMap<String, String> getMultiValueMapHttpEntity() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add(USERNAME, appConfig.username());
        params.add(PASSWORD, appConfig.password());
        params.add(CLIENT_SECRET, appConfig.clientSecret());
        params.add(CLIENT_ID, appConfig.clientId());
        params.add(GRANT_TYPE, appConfig.grantType());
       // params.add(REDIRECT_URI, appConfig.redirectUri());
        return params;
    }
}
