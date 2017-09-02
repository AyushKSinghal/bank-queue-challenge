package com.bank.abc.domain.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@ImmutableStyle
@JsonDeserialize(as = Address.class)
public interface AbstractAddress
{
    String getAddressLine1();

    String getAddressLine2();
    String getCity();
    String getState();
    String getCountry();
    String getPinCode();
    String getLandmark();
}
