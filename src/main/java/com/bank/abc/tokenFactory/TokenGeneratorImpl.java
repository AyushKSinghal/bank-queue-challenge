package com.bank.abc.tokenFactory;

import com.bank.abc.domain.dataaccess.CustomerRespository;
import com.bank.abc.domain.dataaccess.TokenRepository;
import com.bank.abc.domain.entity.person.Customer;
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
    private final CustomerRespository customerRespository;


    @Autowired
    public TokenGeneratorImpl(TokenRepository tokenRepository,
            CustomerRespository customerRespository) {
        this.tokenRepository = tokenRepository;
        this.customerRespository = customerRespository;
    }

    @Override
    public Token generateToken(AbstractTokenInputData tokenInputData)
    {
        final Customer customer = customerRespository.getCustomer(tokenInputData.getCustomerId());
        Token token = Token.builder()
            .withBranchCode(tokenInputData.getBranchCode())
            .withPriority(5)
            .withQueryDescription(tokenInputData.getDescription())
            .withTokenState(TokenState.Created)
            .withCustomer(customer)
            .withCreateTime(DateTime.now().toString())
            .withLastUpdatedTime(DateTime.now().toString())
            .withQuery(tokenInputData.getQueryType())
            .withCounterVisitedList(new HashMap<>())
            .withTokenId("G" + tokenId++)
            .build();
        tokenRepository.saveToken(token);
        return token;
    }
}
