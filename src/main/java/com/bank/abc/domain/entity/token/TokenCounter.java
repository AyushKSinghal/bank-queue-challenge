package com.bank.abc.domain.entity.token;

import com.bank.abc.domain.entity.person.Employee;
import org.joda.time.DateTime;

public class TokenCounter
{
    private DateTime startTime;
    private DateTime endTime;
    private Employee receivedBy;
    private String notes;
}
