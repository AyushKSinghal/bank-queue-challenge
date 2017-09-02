package com.bank.abc.domain.entity.token;

import com.bank.abc.domain.entity.ImmutableStyle;
import com.bank.abc.domain.entity.person.AbstractEmployee;
import org.immutables.value.Value;
import org.joda.time.DateTime;

@Value.Immutable
@ImmutableStyle
public interface AbstractTokenCounter
{
    DateTime getStartTime();
    DateTime getEndTime();
    AbstractEmployee getReceivedBy();
    String getNotes();
}
