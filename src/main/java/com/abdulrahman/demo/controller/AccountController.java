package com.abdulrahman.demo.controller;

import com.abdulrahman.demo.model.Account;
import com.abdulrahman.demo.model.Person;
import com.abdulrahman.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Account> getAllPeople(){

        return accountService.getAccount();
    }
}
