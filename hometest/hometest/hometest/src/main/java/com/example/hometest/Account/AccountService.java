package com.example.hometest.Account;

import java.util.List;

public interface AccountService {
    Account saveAccount(Account Account);

    List<Account> getAllAccounts(Iterable<Long> UserId);

    Account getAccountByNumber(Iterable<Long> UserId, int AccountNumber);

    Account updateAccount(Account Account, long UserId);

    void deleteAccount(long UserId);
}