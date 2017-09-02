package com.bank.abc.domain.api;

import com.bank.abc.domain.entity.Bank;
import com.bank.abc.domain.service.BankService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class BankController
{
    private final BankService bankService;
    @Autowired
    public BankController(BankService bankService){
        this.bankService = bankService;
    }

    @RequestMapping(value = "/",
            method = { RequestMethod.GET },
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Bank> getBank() throws IOException
    {
        return ResponseEntity.ok(bankService.getBank());
    }
}
