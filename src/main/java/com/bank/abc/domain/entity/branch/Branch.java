package com.bank.abc.domain.entity.branch;

import com.bank.abc.domain.entity.Address;
import com.bank.abc.domain.entity.counter.Counter;
import com.bank.abc.domain.entity.person.Employee;

import java.util.List;

public class Branch
{
    private String name;
    private Address address;
    private Employee manager;
    private Employee[] counterStaffList;
    private List<Counter> counterList;

}
