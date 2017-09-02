package com.bank.abc.domain.service;

import com.bank.abc.domain.dataaccess.BankRepository;
import com.bank.abc.domain.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankService
{
    private final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public Bank getBank(){
        return this.bankRepository.getBank();
    }

}
