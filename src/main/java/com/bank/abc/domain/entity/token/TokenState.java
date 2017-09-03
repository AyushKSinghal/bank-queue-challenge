package com.bank.abc.domain.entity.token;

public enum TokenState
{
    Created,
    Queue,
    Processing,
    NextCounterFollowUp,
    BackEndFollowUp,
    Completed,
    Cancelled
}
