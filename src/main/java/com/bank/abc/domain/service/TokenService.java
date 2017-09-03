package com.bank.abc.domain.service;

import com.bank.abc.domain.counterQueue.CounterQueueAssigner;
import com.bank.abc.domain.dataaccess.TokenRepository;
import com.bank.abc.domain.entity.token.AbstractToken;
import com.bank.abc.domain.entity.token.Token;
import com.bank.abc.domain.entity.token.TokenCounter;
import com.bank.abc.domain.entity.token.TokenState;
import com.bank.abc.tokenFactory.TokenGenerator;
import com.bank.abc.tokenFactory.AbstractTokenInputData;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenService
{
    //TODO need to create Token Repository
    private final TokenRepository tokenRepository;
    private final TokenGenerator tokenGenerator;
    private final CounterQueueAssigner counterQueueAssigner;

    @Autowired
    public TokenService(TokenRepository tokenRepository, TokenGenerator tokenGenerator, CounterQueueAssigner counterQueueAssigner) {

        this.tokenRepository = tokenRepository;
        this.tokenGenerator = tokenGenerator;
        this.counterQueueAssigner = counterQueueAssigner;
    }

    public AbstractToken getToken(AbstractTokenInputData tokenInputData){
        Token token = tokenGenerator.generateToken(tokenInputData);
        token = counterQueueAssigner.assignCounter(token);
        tokenRepository.saveToken(token);
        return token;
    }

    public Token updateState(String tokenId, TokenState tokenState){
        Token token = this.tokenRepository.getToken(tokenId);
        token = token
                .withClosedTime(DateTime.now().toString())
                .withTokenState(tokenState);
        //TODO publisher subscriber for state change events
        tokenRepository.saveToken(token);
        return token;
    }

    public Token updateCounterData(String counterCode, String counterUpdate, String tokenId) {
        Token token = tokenRepository.getToken(tokenId);
        //TODO need to fix exception
        if(token.getCounterVisitedList().containsKey(counterCode)) {
            token.getCounterVisitedList().get(counterCode).getNotes().add(counterUpdate);
        } else {
            token.getCounterVisitedList().put(counterCode,
                    TokenCounter.builder()
                            .withCounterCode(counterCode)
                            .addNotes(counterUpdate)
                            .build());
        }
        tokenRepository.saveToken(token);
        return token;
    }

    public Token setNextCounter(String counterCode, String tokenId ){
        Token token = tokenRepository.getToken(tokenId);
        token = token.withNextCounter(counterCode);
        //TODO publisher subscriber for change events
        tokenRepository.saveToken(token);
        return token;
    }

}
