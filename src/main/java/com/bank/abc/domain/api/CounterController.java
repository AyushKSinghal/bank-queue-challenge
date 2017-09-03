package com.bank.abc.domain.api;

import com.bank.abc.domain.entity.counter.AbstractCounter;
import com.bank.abc.domain.entity.token.AbstractToken;
import com.bank.abc.domain.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class CounterController
{
    private final CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService){
        this.counterService = counterService;
    }

    @RequestMapping(value = "/branch/{branchCode}/counter",
            method = { RequestMethod.GET },
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<AbstractCounter>> getCounters(@PathVariable("branchCode") String branchCode) {
        return ResponseEntity.ok(counterService.getCounters(branchCode));
    }

    @RequestMapping(value = "/branch/{branchCode}/counter/{counterCode}",
            method = { RequestMethod.GET },
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<AbstractCounter> getCounter(@PathVariable("branchCode") String branchCode, @PathVariable("counterCode") String counterCode) {
        return ResponseEntity.ok(counterService.getCounter(branchCode, counterCode));
    }

    @RequestMapping(value = "/branch/{branchCode}/counter/{counterCode}/tokenQueue",
            method = { RequestMethod.GET },
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<String>> getTokenQueue(@PathVariable("branchCode") String branchCode, @PathVariable("counterCode") String counterCode) {
        return ResponseEntity.ok(counterService.getTokenQueue(branchCode, counterCode));
    }
}
