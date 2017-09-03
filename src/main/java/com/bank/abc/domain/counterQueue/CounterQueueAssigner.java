package com.bank.abc.domain.counterQueue;

import com.bank.abc.domain.entity.counter.AbstractCounter;
import com.bank.abc.domain.entity.token.AbstractToken;
import com.bank.abc.domain.entity.token.Token;

/**
 * For now created simple strategy, we can create branch specific, or better strategies
 */
public interface CounterQueueAssigner
{
    Token assignCounter(Token token);
}
