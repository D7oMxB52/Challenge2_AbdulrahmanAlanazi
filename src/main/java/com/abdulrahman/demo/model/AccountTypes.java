package com.abdulrahman.demo.model;


public enum AccountTypes {
    TermInv("Term Investment"),
    Loan("Loan"),
    Saving("Saving");

    public final String s;
    private AccountTypes(String s) {
        this.s = s;
    }
}
