package com.bank.abc.domain.entity.token;

import com.bank.abc.domain.entity.ImmutableStyle;
import com.bank.abc.domain.entity.counter.Counter;
import com.bank.abc.domain.entity.person.AbstractEmployee;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.Nullable;
import org.immutables.value.Value;
import org.joda.time.DateTime;

import java.util.List;

@Value.Immutable
@ImmutableStyle
@JsonDeserialize(as = TokenCounter.class)
public interface AbstractTokenCounter
{
    @Nullable
    DateTime getStartTime();

    @Nullable
    DateTime getEndTime();

    @Nullable
    AbstractEmployee getReceivedBy();

    String getCounterCode();

    List<String> getNotes();
}
