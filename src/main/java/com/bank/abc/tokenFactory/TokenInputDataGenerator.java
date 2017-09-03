package com.bank.abc.tokenFactory;

import com.bank.abc.domain.entity.person.Customer;
import com.bank.abc.domain.entity.token.QueryType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by asinghal on 9/3/17.
 */
@Component
public class TokenInputDataGenerator
{
    public TokenInputData getTokenInputData(QueryType queryType, String description, String customerId, String branchCode) {
        return TokenInputData.builder()
                .withDescription(description)
                .withQueryType(queryType)
                .withCustomer(Customer.builder()
                        .withCustomerId(customerId)
                        .withIsGuest(StringUtils.isEmpty(customerId) ? true : false)
                        .build())
                .withBranchCode(branchCode)
                .build();
    }

}
