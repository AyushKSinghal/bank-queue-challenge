package com.bank.abc.domain.service;

import com.bank.abc.domain.dataaccess.BankRepository;
import com.bank.abc.domain.entity.Bank;
import com.bank.abc.domain.entity.branch.AbstractBranch;
import com.bank.abc.domain.entity.branch.Branch;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BranchService
{
    private final BankRepository bankRepository;

    @Autowired
    public BranchService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<AbstractBranch> getBranches(){
        return this.bankRepository.getBank().getBranchList();
    }

    public AbstractBranch getBranch(String branchCode){
        return this.bankRepository.getBank().getBranchList().stream()
                .filter(abstractBranch -> StringUtils.equals(branchCode, abstractBranch.getCode()))
                .findFirst().orElse(null);
    }

}
