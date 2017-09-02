package com.bank.abc.domain.entity.person;

import com.bank.abc.domain.entity.AbstractAddress;
import com.bank.abc.domain.entity.ImmutableStyle;
import com.sun.istack.internal.Nullable;
import org.immutables.value.Value;

@Value.Immutable
@ImmutableStyle
public interface AbstractCustomer
{
    @Nullable
    String getFirtName();

    @Nullable
    String getLastName();

    @Nullable
    String getPhoneNumber();

    @Nullable
    Enum<Gender> getGender();

    @Nullable
    AbstractAddress getAddress();

    @Nullable
    String getCustomerId();

    @Nullable
    CustomerType getCustomerType();

    boolean isGuest();
}
