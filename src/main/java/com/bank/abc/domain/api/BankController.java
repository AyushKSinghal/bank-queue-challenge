package com.bank.abc.domain.api;

import com.bank.abc.domain.entity.AbstractBank;
import com.bank.abc.domain.entity.Bank;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController
{
    @RequestMapping(value = "/",
            method = { RequestMethod.GET },
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Bank> getBank() {
        return ResponseEntity.ok(Bank.builder()
                .withName("ABC Bank")
                .build());
    }
}
