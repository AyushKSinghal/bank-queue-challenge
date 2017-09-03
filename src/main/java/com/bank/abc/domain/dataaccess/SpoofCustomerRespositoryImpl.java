package com.bank.abc.domain.dataaccess;

import com.bank.abc.domain.entity.person.Customer;
import com.bank.abc.domain.entity.person.CustomerType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asinghal on 9/3/17.
 */
@Component
public class SpoofCustomerRespositoryImpl implements CustomerRespository
{
    private final Map<String, Customer> customerMap;
    public SpoofCustomerRespositoryImpl(){
        customerMap = new HashMap<>();
        customerMap.put("customer1", Customer.builder()
                .withCustomerId("customer1")
                .withCustomerType(CustomerType.Preffered)
                .withIsGuest(false)
                .build());
        customerMap.put("customer2", Customer.builder()
                .withCustomerId("customer2")
                .withCustomerType(CustomerType.Classic)
                .withIsGuest(false)
                .build());
    }

    @Override public Customer getCustomer(String customerId)
    {
        Customer customer = customerMap.get(customerId);
        if(customer != null) {
            return customer;
        }
        return Customer.builder()
                .withCustomerId(customerId)
                .withIsGuest(StringUtils.isEmpty(customerId) ? true : false)
                .build();
    }
}
