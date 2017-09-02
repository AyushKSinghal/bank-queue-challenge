package com.bank.abc.domain.entity.branch;

import com.bank.abc.domain.entity.AbstractAddress;
import com.bank.abc.domain.entity.ImmutableStyle;
import com.bank.abc.domain.entity.counter.AbstractCounter;
import com.bank.abc.domain.entity.person.AbstractEmployee;
import com.sun.istack.internal.Nullable;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@ImmutableStyle
public interface AbstractBranch
{
    String getName();

    @Nullable
    AbstractAddress getAddress();

    @Nullable
    AbstractEmployee getManager();

    @Nullable
    AbstractEmployee[] getCounterStaffList();

    @Nullable
    List<AbstractCounter> getCounterList();

}
