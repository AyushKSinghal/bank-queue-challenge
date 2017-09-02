package com.bank.abc;

import com.bank.abc.domain.dataaccess.BankRepository;
import com.bank.abc.domain.service.BankService;
import com.bank.abc.domain.service.CounterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean CounterService getCounterService(BankRepository bankRepository) {
        return new CounterService(bankRepository);
    }

}