package com.accountservice.accountservice.controller;

import com.accountservice.accountservice.model.Account;
import com.accountservice.accountservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    // CREATE ACCOUNT
    @RequestMapping(value="/account", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public Account SaveAccount(@RequestBody Account account){
        System.out.println("DATA IS :"+account.getAccountTypes());
        return accountService.createAccount(account);
    }

    // GET ALL ACCOUNTS
    @RequestMapping(value = "/accounts/account", method = RequestMethod.GET,produces="application/json")
    public List<Account> getAllAccount(){
        return accountService.getAllAccount();
    }

    // GET SPECIFIC ACCOUNT
    @RequestMapping(value = "/account/account{id}", method = RequestMethod.GET,produces="application/json")
    public Account getAccount(@PathVariable("id") Integer id){
        return accountService.getAccount(id);
    }

    // UPDATE ACCOUNT
    @RequestMapping(value="/accounts/account", method = RequestMethod.PUT, produces="application/json", consumes="application/json")
    public Account updatePerson(@RequestBody Account account){
        return accountService.updateAccount(account.getId(), account);
    }

    // DELETE ACCOUNT
    @RequestMapping(value = "/accounts/account", method = RequestMethod.DELETE,consumes="application/json")
    public void deleteAccount(@RequestBody Account account){
        accountService.deleteAccount(account.getId());
    }
}
