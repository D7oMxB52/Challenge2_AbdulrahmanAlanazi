package com.accountservice.accountservice.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountTypes accountTypes;

    @Column
    private String accountNumber;
    @Column
    private String accountName;

    @Column
    private String Balance;

    @Column
    private Date date;

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AccountTypes getAccountTypes() {
        return accountTypes;
    }

    public void setAccountTypes(AccountTypes accountTypes) {
        this.accountTypes = accountTypes;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
