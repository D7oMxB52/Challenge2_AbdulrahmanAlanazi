package com.abdulrahman.demo.services;

import com.abdulrahman.demo.dao.AccountDao;
import com.abdulrahman.demo.model.Account;
import com.abdulrahman.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    // CREATE ACCOUNT
    public Account createAccount(Account account){
        int numOfPeople = accountDao.findAll().size();
        account.setId(numOfPeople+1);
        return accountDao.save(account);
    }

    // GET ALL ACCOUNTS IN DATABASE
    public List<Account> getPeople() {
        return accountDao.findAll();
    }

    // GET ACCOUNT BY ID
    public Account getAccount(Integer id){
        return accountDao.findById(id).get();
    }

    // DELETE ACCOUNT
    public void deleteAccount(Integer id){
        accountDao.deleteById(id);
        System.out.println("Account with ID: "+
                id+" has been deleted.");
    }

    // UPDATE ACCOUNT
    public Account updatePerson(Integer id, Account account){
        Account existedAccount = accountDao.findById(id).get();
        existedAccount.setAccountName(account.getAccountName());
        existedAccount.setAccountTypes(account.getAccountTypes());
        existedAccount.setAccountNumber(account.getAccountNumber());
        existedAccount.setAccountName(account.getAccountName());
        existedAccount.setDate(account.getDate());


        return accountDao.save(existedAccount);
    }
}