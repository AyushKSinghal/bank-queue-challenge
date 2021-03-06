package com.bank.abc.domain.entity.person;

import com.bank.abc.domain.entity.AbstractAddress;
import com.bank.abc.domain.entity.ImmutableStyle;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@ImmutableStyle
@JsonDeserialize(as = Employee.class)
public interface AbstractEmployee
{
    String getFirtName();
    String getLastName();
    String getPhoneNumber();
    Enum<Gender> getGender();
    AbstractAddress getAddress();

    String getEmployeeId();
}
