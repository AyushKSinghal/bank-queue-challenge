package com.bank.abc.tokenFactory;

import com.bank.abc.domain.entity.token.AbstractToken;
import org.springframework.stereotype.Component;

@Component
public class TokenGeneratorImpl implements TokenGenerator
{
    @Override
    public AbstractToken generateToken(TokenQuery tokenQuery)
    {
        return null;
    }
}
