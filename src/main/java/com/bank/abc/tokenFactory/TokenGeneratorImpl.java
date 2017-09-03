package com.bank.abc.tokenFactory;

import com.bank.abc.domain.dataaccess.TokenRepository;
import com.bank.abc.domain.entity.token.AbstractTokenCounter;
import com.bank.abc.domain.entity.token.Token;
import com.bank.abc.domain.entity.token.TokenState;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TokenGeneratorImpl implements TokenGenerator
{
    private final TokenRepository tokenRepository;
    private int tokenId = 1;

    @Autowired
    public TokenGeneratorImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Token generateToken(AbstractTokenInputData tokenInputData)
    {
        Token token = Token.builder()
            .withBranchCode(tokenInputData.getBranchCode())
            .withPriority(5)
            .withQueryDescription(tokenInputData.getDescription())
            .withTokenState(TokenState.Created)
            .withCustomer(tokenInputData.getCustomer())
            .withCreateTime(DateTime.now().toString())
            .withLastUpdatedTime(DateTime.now().toString())
            .withQuery(tokenInputData.getQueryType())
            .withCounterVisitedList(new HashMap<String, AbstractTokenCounter>())
            .withTokenId("G" + tokenId++)
            .build();
        tokenRepository.saveToken(token);
        return token;
    }
}
