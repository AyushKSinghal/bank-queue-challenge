package com.bank.abc.domain.entity.person;

import com.bank.abc.domain.entity.AbstractAddress;
import com.bank.abc.domain.entity.ImmutableStyle;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.Nullable;
import org.immutables.value.Value;

@Value.Immutable
@ImmutableStyle
@JsonDeserialize(as = Customer.class)
public interface AbstractCustomer
{
//    String getFirtName();
//
//    String getLastName();
//
//    String getPhoneNumber();
//
//    Enum<Gender> getGender();
//
//    AbstractAddress getAddress();

    String getCustomerId();

    @Nullable
    CustomerType getCustomerType();

    boolean isGuest();
}
