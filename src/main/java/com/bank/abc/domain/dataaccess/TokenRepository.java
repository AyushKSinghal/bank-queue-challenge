package com.bank.abc.domain.dataaccess;

import com.bank.abc.domain.entity.Bank;
import com.bank.abc.domain.entity.token.AbstractToken;
import com.bank.abc.domain.entity.token.Token;

/**
 * Created by asinghal on 9/3/17.
 */
public interface TokenRepository
{
    boolean saveToken(Token token);
    Token getToken(String tokenId);
}
