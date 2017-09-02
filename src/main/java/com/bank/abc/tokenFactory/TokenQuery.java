package com.bank.abc.tokenFactory;

import com.bank.abc.domain.entity.person.AbstractCustomer;
import com.bank.abc.domain.entity.token.QueryType;

/**
 * Created by asinghal on 9/2/17.
 */
public class TokenQuery
{
    private QueryType queryType;
    private String description;
    private AbstractCustomer customer;
}
