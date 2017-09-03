package com.bank.abc.tokenFactory;

import com.bank.abc.domain.entity.ImmutableStyle;
import com.bank.abc.domain.entity.person.AbstractCustomer;
import com.bank.abc.domain.entity.token.QueryType;
import org.immutables.value.Value;

@Value.Immutable
@ImmutableStyle
public interface AbstractTokenInputData
{
    QueryType getQueryType();
    String getDescription();
    String getCustomerId();
    String getBranchCode();
}
