package com.example.hometest.Account;

import java.util.List;

public interface AccountService {
    Account saveAccount(Account Account);

    List<Account> getAllAccounts();

    Account getAccountByUserId(long UserId);

    Account updateAccount(Account Account, long UserId);

    void deleteAccount(long UserId);
}