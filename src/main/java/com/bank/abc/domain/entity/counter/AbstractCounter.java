package com.bank.abc.domain.entity.counter;

import com.bank.abc.domain.entity.ImmutableStyle;
import com.bank.abc.domain.entity.person.AbstractEmployee;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;

@Value.Immutable
@ImmutableStyle
@JsonDeserialize(as = Counter.class)
public interface AbstractCounter
{
    String getName();

    CounterState getState();
    CounterType getPrimaryCounterType();

    List<CounterType> getSecondaryCounterTypes();

    Optional<AbstractEmployee> getHandledBy();
}
