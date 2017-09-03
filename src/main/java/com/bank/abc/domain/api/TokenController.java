package com.bank.abc.domain.api;

import com.bank.abc.domain.entity.counter.AbstractCounter;
import com.bank.abc.domain.entity.token.AbstractToken;
import com.bank.abc.domain.entity.token.QueryType;
import com.bank.abc.domain.entity.token.Token;
import com.bank.abc.domain.entity.token.TokenState;
import com.bank.abc.domain.service.CounterService;
import com.bank.abc.domain.service.TokenService;
import com.bank.abc.tokenFactory.TokenInputDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TokenController
{
    private final TokenService tokenService;
    private final TokenInputDataGenerator tokenInputDataGenerator;

    @Autowired
    public TokenController(TokenService tokenService, TokenInputDataGenerator tokenInputDataGenerator){
        this.tokenService = tokenService;
        this.tokenInputDataGenerator = tokenInputDataGenerator;
    }

    @RequestMapping(value = "/branch/{branchCode}/token",
            method = { RequestMethod.PUT },
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<AbstractToken> getToken(
            @PathVariable("branchCode") String branchCode,
            @RequestParam("description") String description,
            @RequestParam("queryType") QueryType queryType,
            @RequestParam("customerId") String customerId) {
        //TODO remove from add to counter queue
        return ResponseEntity.ok(tokenService.getToken(tokenInputDataGenerator.getTokenInputData(queryType, description, customerId, branchCode)));
    }

    @RequestMapping(value = "/branch/{branchCode}/token/{tokenId}/counter/{counterCode}/update",
            method = { RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Token> getUpdateToken(
            @PathVariable("branchCode") String branchCode,
            @PathVariable("tokenId") String tokenId,
            @PathVariable("counterCode") String counterCode,
            @RequestParam("description") String descriptionUpdate
            ) {
        return ResponseEntity.ok(tokenService.updateCounterData(counterCode, descriptionUpdate, tokenId));
    }

    @RequestMapping(value = "/branch/{branchCode}/token/{tokenId}/setNextCounter",
            method = { RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Token> setNextCounter(
            @PathVariable("branchCode") String branchCode,
            @PathVariable("tokenId") String tokenId,
            @RequestParam("counterCode") String counterCode
    ) {
        return ResponseEntity.ok(tokenService.setNextCounter(counterCode, tokenId));
    }

    @RequestMapping(value = "/branch/{branchCode}/token/{tokenId}/complete",
            method = { RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Token> getCompleteToken(
            @PathVariable("branchCode") String branchCode,
            @PathVariable("tokenId") String tokenId
           ) {
        //TODO remove from counter queue
        return ResponseEntity.ok(tokenService.updateState(tokenId, TokenState.Completed));
    }

    @RequestMapping(value = "/branch/{branchCode}/token/{tokenId}/cancel",
            method = { RequestMethod.POST },
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Token> getCancelToken(
            @PathVariable("branchCode") String branchCode,
            @PathVariable("tokenId") String tokenId
    ) {
        //TODO remove from counter queue

        return ResponseEntity.ok(tokenService.updateState(tokenId, TokenState.Cancelled));
    }
}
