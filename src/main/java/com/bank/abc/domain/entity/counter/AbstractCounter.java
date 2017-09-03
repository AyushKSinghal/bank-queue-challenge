package com.bank.abc.domain.entity.counter;

import com.bank.abc.domain.entity.ImmutableStyle;
import com.bank.abc.domain.entity.person.AbstractEmployee;
import com.bank.abc.domain.entity.token.AbstractToken;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.Nullable;
import org.immutables.value.Value;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Value.Immutable
@ImmutableStyle
@JsonDeserialize(as = Counter.class)
public interface AbstractCounter
{
    String getName();

    String getCode();

    CounterState getState();

    @Nullable
    LinkedList<String> getTokenQueue();

    CounterType getPrimaryCounterType();

    List<CounterType> getSecondaryCounterTypes();

    @Nullable
    AbstractEmployee getHandledBy();
}
