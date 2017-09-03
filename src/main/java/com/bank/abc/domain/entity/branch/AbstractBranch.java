package com.bank.abc.domain.entity.branch;

import com.bank.abc.domain.entity.AbstractAddress;
import com.bank.abc.domain.entity.ImmutableStyle;
import com.bank.abc.domain.entity.counter.AbstractCounter;
import com.bank.abc.domain.entity.counter.Counter;
import com.bank.abc.domain.entity.person.AbstractEmployee;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;

@Value.Immutable
@ImmutableStyle
@JsonDeserialize(as = Branch.class)
public interface AbstractBranch
{
    String getName();

    String getCode();

    Optional<AbstractAddress> getAddress();

    Optional<AbstractEmployee> getManager();

    List<AbstractEmployee> getStaffList();

    List<Counter> getCounterList();

}
