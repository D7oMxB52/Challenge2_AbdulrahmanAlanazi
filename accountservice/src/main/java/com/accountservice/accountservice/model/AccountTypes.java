package com.accountservice.accountservice.model;


public enum AccountTypes {
    Term_Investment("Term Investment"),
    Loan("Loan"),
    Saving("Saving");

    public String s;
    AccountTypes(String s) {
        this.s = s;
    }
}
