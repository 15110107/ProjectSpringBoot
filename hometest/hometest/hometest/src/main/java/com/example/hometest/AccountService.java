package com.example.hometest;

import java.util.List;

import com.example.hometest.Account.Account;

public interface AccountService {
    Account saveAccount(Account Account);

    List<Account> getAllAccounts();

    Account getAccountByUserId(long UserId);

    Account updateAccount(Account Account, long UserId);

    void deleteAccount(long UserId);
}