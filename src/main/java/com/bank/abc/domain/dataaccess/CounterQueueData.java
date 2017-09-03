package com.bank.abc.domain.dataaccess;

import com.bank.abc.domain.entity.branch.AbstractBranch;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by asinghal on 9/3/17.
 */
@Component
public class CounterQueueData
{
    List<AbstractBranch> branchList;

    @Autowired
    public CounterQueueData(BankRepository bankRepository){
        this.branchList = bankRepository.getBank().getBranchList();
    }

    public void addTokenToCounterQueue(String branchCode, String counterCode, String tokenId) {
        branchList.stream()
                .filter(abstractBranch -> StringUtils.equals(branchCode, abstractBranch.getCode()))
                .flatMap(abstractBranch -> abstractBranch.getCounterList().stream())
                .filter(abstractCounter -> StringUtils.equals(counterCode, abstractCounter.getCode()))
                .findFirst()
                .ifPresent(abstractCounter -> {
                    if(abstractCounter.getTokenQueue() == null) {
                        abstractCounter = abstractCounter.withTokenQueue(new LinkedList<>());
                    }
                    abstractCounter.getTokenQueue().push(tokenId);
                });

    }

    public void removeTokenFromCounterQueue(String branchCode, String counterCode, String tokenId) {
        branchList.stream()
                .filter(abstractBranch -> StringUtils.equals(branchCode, abstractBranch.getCode()))
                .flatMap(abstractBranch -> abstractBranch.getCounterList().stream())
                .filter(abstractCounter -> StringUtils.equals(counterCode, abstractCounter.getCode()))
                .findFirst()
                .ifPresent(abstractCounter -> {
                    if(abstractCounter.getTokenQueue() == null) {
                        abstractCounter = abstractCounter.withTokenQueue(new LinkedList<>());
                    }
                    if(abstractCounter.getTokenQueue().contains(tokenId)) {
                        abstractCounter.getTokenQueue().remove(tokenId);
                    }
                });
    }
}
