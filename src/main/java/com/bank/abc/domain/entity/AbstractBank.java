package com.bank.abc.domain.entity;

import com.bank.abc.domain.entity.branch.AbstractBranch;
import com.sun.istack.internal.Nullable;
import org.immutables.value.Value;

@Value.Immutable
@ImmutableStyle
public interface AbstractBank
{
    String getName();
    @Nullable
    AbstractBranch[] getBranchList();

 }
