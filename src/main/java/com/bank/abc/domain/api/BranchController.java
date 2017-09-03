package com.bank.abc.domain.api;

import com.bank.abc.domain.entity.Bank;
import com.bank.abc.domain.entity.branch.AbstractBranch;
import com.bank.abc.domain.entity.branch.Branch;
import com.bank.abc.domain.service.BankService;
import com.bank.abc.domain.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BranchController
{

    private final BranchService branchService;
    @Autowired
    public BranchController(BranchService branchService){
        this.branchService = branchService;
    }

    @RequestMapping(value = "/branch",
            method = { RequestMethod.GET },
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<AbstractBranch>> getBranches() {
        return ResponseEntity.ok(branchService.getBranches());
    }
}
