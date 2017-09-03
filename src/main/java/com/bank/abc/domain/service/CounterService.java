package com.bank.abc.domain.service;

import com.bank.abc.domain.dataaccess.BankRepository;
import com.bank.abc.domain.dataaccess.CounterQueueData;
import com.bank.abc.domain.entity.counter.AbstractCounter;
import com.bank.abc.domain.entity.counter.Counter;
import com.bank.abc.domain.entity.token.AbstractToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
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

    public List<AbstractCounter> getCounters(String branchCode){
        return this.bankRepository.getBank().getBranchList().stream()
                .filter(abstractBranch -> StringUtils.equals(abstractBranch.getCode(), branchCode))
                .flatMap(abstractBranch -> abstractBranch.getCounterList().stream())
                .collect(Collectors.toList());
    }

    public AbstractCounter getCounter(String branchCode, String counterCode){
        return this.bankRepository.getBank().getBranchList().stream()
                .filter(abstractBranch -> StringUtils.equals(abstractBranch.getCode(), branchCode))
                .flatMap(abstractBranch -> abstractBranch.getCounterList().stream())
                .filter(counter -> StringUtils.equals(counter.getCode(), counterCode))
                .findFirst().orElse(null);
    }

    public List<String> getTokenQueue(String branchCode, String counterCode){
        Optional<Counter> currentCounter = this.bankRepository.getBank().getBranchList().stream()
                .filter(abstractBranch -> StringUtils.equals(abstractBranch.getCode(), branchCode))
                .flatMap(abstractBranch -> abstractBranch.getCounterList().stream())
                .filter(counter -> StringUtils.equals(counter.getCode(), counterCode))
                .findFirst();
        return currentCounter.isPresent()  ? currentCounter.get().getTokenQueue() : Collections.emptyList();
    }

}
