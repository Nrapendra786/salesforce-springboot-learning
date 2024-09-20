package com.nrapendra.springboot_force_demo.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final SalesforceDataService salesforceDataService;

    public Map<?, ?> getAccountList() {
        String query = "SELECT Id,Name from ACCOUNT";
        return salesforceDataService.getSalesforceData(query);
    }

}
