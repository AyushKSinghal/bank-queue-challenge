package com.bank.abc.domain.service;

import com.bank.abc.domain.dataaccess.BankRepository;
import com.bank.abc.domain.entity.counter.AbstractCounter;
import com.bank.abc.domain.entity.token.AbstractToken;
import com.bank.abc.tokenFactory.TokenGenerator;
import com.bank.abc.tokenFactory.TokenQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TokenService
{
    //TODO need to create Token Repository
    private final BankRepository bankRepository;
    private final TokenGenerator tokenGenerator;

    @Autowired
    public TokenService(BankRepository bankRepository, TokenGenerator tokenGenerator) {

        this.bankRepository = bankRepository;
        this.tokenGenerator = tokenGenerator;
    }

    public AbstractToken getToken(TokenQuery tokenQuery){
        return tokenGenerator.generateToken(tokenQuery);
    }

}
