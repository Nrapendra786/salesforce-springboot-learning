package com.nrapendra.springboot_force_demo.account;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping(value = "/accounts")
    public Map getAccount(){
        try {
            return accountService.getAccountList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Collections.emptyMap();
    }
}
