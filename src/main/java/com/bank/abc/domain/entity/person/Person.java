package com.bank.abc.domain.entity.person;

import com.bank.abc.domain.entity.Address;

public abstract class Person
{
    protected String firtName;
    protected String lastName;
    protected String phoneNumber;
    protected Enum<Gender> gender;
    private Address address;

}
