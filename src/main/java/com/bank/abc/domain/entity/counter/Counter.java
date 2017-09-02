package com.bank.abc.domain.entity.counter;

import com.bank.abc.domain.entity.person.Employee;

public class Counter
{
    private String name;
    private CounterState state;
    private CounterType primaryCounterType;
    private CounterType[] secondaryCounterTypes;
    private Employee handleBy;
}
