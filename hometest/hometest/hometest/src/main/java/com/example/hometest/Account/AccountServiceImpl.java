package com.example.hometest.Account;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.hometest.ResourceNotFoundException;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        super();
        this.accountRepository = accountRepository;
    }

    @Override
    public Account saveAccount(Account Account) {
        return accountRepository.save(Account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountByUserId(long UserId) {
        return accountRepository.findById(UserId).orElseThrow(
                () -> new ResourceNotFoundException("Account", "UserId", UserId));
    }

    @Override
    public Account updateAccount(Account Account, long UserId) {

        Account existingAccount = accountRepository.findById(UserId).orElseThrow(
                () -> new ResourceNotFoundException("Account", "UserId", UserId));

        existingAccount.setAccountNumber(Account.getAccountNumber());
        existingAccount.setBalance(Account.getBalance());
        accountRepository.save(existingAccount);
        return existingAccount;
    }

    @Override
    public void deleteAccount(long UserId) {
        accountRepository.findById(UserId).orElseThrow(
                () -> new ResourceNotFoundException("Account", "UserId", UserId));
        accountRepository.deleteById(UserId);
    }
}
