package com.bank.abc.domain.entity;

import com.bank.abc.domain.entity.branch.AbstractBranch;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;

@Value.Immutable
@ImmutableStyle
@JsonDeserialize(as = Bank.class)
public interface AbstractBank
{
    String getName();

    List<AbstractBranch> getBranchList();

 }
