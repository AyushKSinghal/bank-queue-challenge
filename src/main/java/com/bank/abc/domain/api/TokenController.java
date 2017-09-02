package com.bank.abc.domain.api;

import com.bank.abc.domain.entity.counter.AbstractCounter;
import com.bank.abc.domain.entity.token.AbstractToken;
import com.bank.abc.domain.service.CounterService;
import com.bank.abc.domain.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TokenController
{
    private final TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @RequestMapping(value = "/branch/{branchCode}/token",
            method = { RequestMethod.PUT },
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<AbstractToken> getToken(@PathVariable("branchCode") String branchCode) {
        return ResponseEntity.ok(tokenService.getToken(null));
    }
}
