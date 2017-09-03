package com.bank.abc.domain.dataaccess;

import com.bank.abc.domain.entity.Bank;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by asinghal on 9/3/17.
 */
@Component
public class SpoofBankRepositoryImpl implements BankRepository
{
    private final Bank bank;
    public SpoofBankRepositoryImpl() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        this.bank = objectMapper.readValue(getClass().getClassLoader().getResourceAsStream("static/bank.json"), Bank.class);
    }

    @Override
    public Bank getBank()
    {
        return bank;
    }
}
