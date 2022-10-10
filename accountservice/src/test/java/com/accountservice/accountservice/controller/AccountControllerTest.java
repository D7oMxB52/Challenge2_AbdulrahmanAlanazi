package com.accountservice.accountservice.controller;

import com.accountservice.accountservice.model.Account;
import com.accountservice.accountservice.model.AccountTypes;
import com.accountservice.accountservice.services.AccountService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @MockBean
    AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @Autowired
    private MockMvc mockMvc;

    Account account1 = new Account(1, AccountTypes.Loan,"213","abdul","33", Date.valueOf("2022-10-11"));
    Account account2 = new Account(2, AccountTypes.Saving,"445","wania","55", Date.valueOf("2022-10-11"));
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
    }


    
    @Test
    void getAllAccounts() throws Exception {
        List<Account> accounts = new ArrayList<>(Arrays.asList(account1,account2));
        Mockito.when(accountService.getAllAccount()).thenReturn(accounts);
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/accounts/account")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));


    }

    @Test
    void shouldGetAccount() throws Exception {
        when(accountService.getAccount(1)).thenReturn(account1);
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/account/account1").contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()", Matchers.is(6)));
    }

    @Test
    void shouldGiveInternalServerError() throws Exception{
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/account/account")
                )
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
}