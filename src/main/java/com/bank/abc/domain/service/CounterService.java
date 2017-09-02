package com.bank.abc.domain.service;

import com.bank.abc.domain.dataaccess.BankRepository;
import com.bank.abc.domain.entity.counter.AbstractCounter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CounterService
{
    //TODO need to create Counter Repository
    private final BankRepository bankRepository;

    @Autowired
    public CounterService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<AbstractCounter> getCounters(String branchName){
        return this.bankRepository.getBank().getBranchList().stream()
                .filter(abstractBranch -> StringUtils.equals(abstractBranch.getName(), branchName))
                .flatMap(abstractBranch -> abstractBranch.getCounterList().stream())
                .collect(Collectors.toList());
    }

}
