package com.bank.abc.tokenFactory;

import com.bank.abc.domain.entity.token.AbstractToken;

public interface TokenGenerator
{
    AbstractToken generateToken(TokenQuery tokenQuery);
}
