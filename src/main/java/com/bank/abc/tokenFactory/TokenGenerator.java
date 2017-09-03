package com.bank.abc.tokenFactory;

import com.bank.abc.domain.entity.token.AbstractToken;
import com.bank.abc.domain.entity.token.Token;

public interface TokenGenerator
{
    Token generateToken(AbstractTokenInputData tokenInputData);
}
