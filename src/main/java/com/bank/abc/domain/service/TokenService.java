package com.bank.abc.domain.service;

import com.bank.abc.domain.counterQueue.CounterQueueAssigner;
import com.bank.abc.domain.dataaccess.CounterQueueData;
import com.bank.abc.domain.dataaccess.TokenRepository;
import com.bank.abc.domain.entity.token.AbstractToken;
import com.bank.abc.domain.entity.token.Token;
import com.bank.abc.domain.entity.token.TokenCounter;
import com.bank.abc.domain.entity.token.TokenState;
import com.bank.abc.tokenFactory.TokenGenerator;
import com.bank.abc.tokenFactory.AbstractTokenInputData;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class TokenService
{
    //TODO need to create Token Repository
    private final TokenRepository tokenRepository;
    private final TokenGenerator tokenGenerator;
    private final CounterQueueAssigner counterQueueAssigner;
    private final CounterQueueData counterQueueData;

    @Autowired
    public TokenService(TokenRepository tokenRepository,
            TokenGenerator tokenGenerator,
            CounterQueueAssigner counterQueueAssigner,
            CounterQueueData counterQueueData) {

        this.tokenRepository = tokenRepository;
        this.tokenGenerator = tokenGenerator;
        this.counterQueueAssigner = counterQueueAssigner;
        this.counterQueueData = counterQueueData;
    }

    public AbstractToken getToken(AbstractTokenInputData tokenInputData){
        Token token = tokenGenerator.generateToken(tokenInputData);
        token = counterQueueAssigner.assignCounter(token);
        counterQueueData.addTokenToCounterQueue(token.getBranchCode(), token.getNextCounter(), token.getTokenId());
        tokenRepository.saveToken(token);
        return token;
    }

    public Token updateState(String tokenId, TokenState tokenState){
        Token token = this.tokenRepository.getToken(tokenId);
        if(tokenState == TokenState.Completed || tokenState == TokenState.Cancelled) {
            counterQueueData.removeTokenFromCounterQueue(token.getBranchCode(), token.getNextCounter(), tokenId);
            token = token.withNextCounter(null).withClosedTime(DateTime.now().toString());
        }
        token = token
                .withTokenState(tokenState);
        tokenRepository.saveToken(token);
        return token;
    }

    public Token updateCounterData(String counterCode, String counterUpdate, String tokenId) {
        Token token = tokenRepository.getToken(tokenId);
        if(token.getCounterVisitedList().containsKey(counterCode)) {
            TokenCounter tokenCounter = token.getCounterVisitedList().get(counterCode);
            tokenCounter = tokenCounter.withNotes().withNotes(
                    CollectionUtils.collate(token.getCounterVisitedList().get(counterCode).getNotes(),
                    Collections.singleton(counterUpdate)));
            token.getCounterVisitedList().put(counterCode,tokenCounter);
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
        if(StringUtils.isNotEmpty(token.getNextCounter())) {
            counterQueueData.removeTokenFromCounterQueue(token.getBranchCode(), token.getNextCounter(), tokenId);
        }
        token = token.withNextCounter(counterCode);
        counterQueueData.addTokenToCounterQueue(token.getBranchCode(), token.getNextCounter(), tokenId);
        tokenRepository.saveToken(token);
        return token;
    }

}
