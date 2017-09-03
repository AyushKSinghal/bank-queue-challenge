package com.bank.abc.domain.counterQueue;

import com.bank.abc.domain.counterQueue.CounterQueueAssigner;
import com.bank.abc.domain.dataaccess.CustomerRespository;
import com.bank.abc.domain.entity.branch.AbstractBranch;
import com.bank.abc.domain.entity.counter.CounterType;
import com.bank.abc.domain.entity.person.CustomerType;
import com.bank.abc.domain.entity.token.Token;
import com.bank.abc.domain.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by asinghal on 9/3/17.
 */
@Component
public class SimpleCounterQueueAssignerImpl implements CounterQueueAssigner
{
    private final BranchService branchService;

    @Autowired
    public SimpleCounterQueueAssignerImpl(BranchService branchService) {
        this.branchService = branchService;

    }

    @Override
    public Token assignCounter(Token token)
    {
        AbstractBranch branch = this.branchService.getBranch(token.getBranchCode());
        if(token.getCustomer().getCustomerType() != null && token.getCustomer().getCustomerType() == CustomerType.Preffered) {
            return token.withNextCounter(
                    branch.getCounterList().stream()
                            .filter(counter -> counter.getPrimaryCounterType() == CounterType.PreferredCustomer)
                            .findFirst()
                            .orElse(branch.getCounterList()
                                    .get(0))
                            .getCode());
        }

        return token.withNextCounter(branch.getCounterList().get(0).getCode());
    }
}
