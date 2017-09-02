package com.bank.abc.domain.entity.counter;

import com.bank.abc.domain.entity.person.AbstractEmployee;
import com.sun.istack.internal.Nullable;

public interface AbstractCounter
{
    String getName();

    @Nullable
    CounterState getState();
    CounterType getPrimaryCounterType();

    @Nullable
    CounterType[] getSecondaryCounterTypes();

    @Nullable
    AbstractEmployee getHandledBy();
}
