package com.bank.abc.domain.token;

import com.bank.abc.domain.entity.counter.AbstractCounter;
import com.bank.abc.domain.entity.token.AbstractToken;

/**
 * Created by asinghal on 9/2/17.
 */
public interface CounterQueueAssigner
{
    AbstractCounter assignCounter(AbstractToken token);
}
