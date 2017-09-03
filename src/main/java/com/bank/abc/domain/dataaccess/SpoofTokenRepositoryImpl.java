package com.bank.abc.domain.dataaccess;

import com.bank.abc.domain.entity.token.AbstractToken;
import com.bank.abc.domain.entity.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asinghal on 9/3/17.
 */
@Component
public class SpoofTokenRepositoryImpl implements TokenRepository
{

    Map<String, Token> cachedData = new HashMap<>();
    @Override public boolean saveToken(Token abstractToken)
    {
        if(cachedData.containsKey(abstractToken.getTokenId())) {
            cachedData.remove(abstractToken.getTokenId());
        }
        cachedData.put(abstractToken.getTokenId(), abstractToken);
        return true;
    }

    @Override public Token getToken(String tokenId)
    {
        return cachedData.get(tokenId);
    }
}
