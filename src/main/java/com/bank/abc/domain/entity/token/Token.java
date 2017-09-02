package com.bank.abc.domain.entity.token;

import com.bank.abc.domain.entity.branch.Branch;
import com.bank.abc.domain.entity.counter.Counter;
import com.bank.abc.domain.entity.person.Customer;
import org.joda.time.DateTime;

import java.util.List;

public class Token
{
    private int priority;
    private int tokenNumber;
    private TokenState tokenState;
    private QueryType query;
    private String queryDescription;
    private Customer customer;
    private DateTime createTime;
    private DateTime lastUpdatedTime;
    private DateTime closedTime;
    private Branch branch;
    private Counter nextCounter;
    private List<TokenCounter> counterVisitedList;
}
