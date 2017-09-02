package com.bank.abc.domain.entity;

import com.sun.istack.internal.Nullable;
import org.immutables.value.Value;

@Value.Immutable
@ImmutableStyle
public interface AbstractAddress
{
    String getAddressLine1();

    @Nullable
    String getAddressLine2();
    String getCity();
    String getState();
    String getCountry();
    String getPinCode();
    String getLandmark();
}
