package com.bank.abc.domain.entity.token;

import com.bank.abc.domain.entity.ImmutableStyle;
import com.bank.abc.domain.entity.branch.AbstractBranch;
import com.bank.abc.domain.entity.counter.AbstractCounter;
import com.bank.abc.domain.entity.counter.Counter;
import com.bank.abc.domain.entity.person.AbstractCustomer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;
import org.joda.time.DateTime;

import java.util.List;

@Value.Immutable
@ImmutableStyle
@JsonDeserialize(as = Token.class)
public interface AbstractToken
{
    int getPriority();
    String getTokenId();
    TokenState getTokenState();
    QueryType getQuery();
    String getQueryDescription();
    AbstractCustomer getCustomer();
    DateTime getCreateTime();
    DateTime getLastUpdatedTime();
    DateTime getClosedTime();
    AbstractBranch getBranch();
    AbstractCounter getNextCounter();
    List<AbstractTokenCounter> getCounterVisitedList();
}
