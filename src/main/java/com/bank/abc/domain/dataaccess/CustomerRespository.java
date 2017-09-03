package com.bank.abc.domain.dataaccess;

import com.bank.abc.domain.entity.person.Customer;

/**
 * Created by asinghal on 9/3/17.
 */
public interface CustomerRespository
{
    public Customer getCustomer(String customerId);
}
