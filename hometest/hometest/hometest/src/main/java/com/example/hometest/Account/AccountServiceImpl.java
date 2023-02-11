package com.example.hometest.Account;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.hometest.Module.*;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        super();
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() {
        try {
            return accountRepository.findAll();
        } catch (Exception e) {
            new ResourceErrorException("Exception", "Error", e);
            return null;
        }
    }

    @Override
    public Account getAccountByUserId(long UserId) {
        try {
            return accountRepository.findById(UserId).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "UserId", UserId));
        } catch (Exception e) {
            new ResourceErrorException("Exception", "Error", e);
            return null;
        }
    }

    @Override
    public Account saveAccount(Account Account) {
        try {
            return accountRepository.save(Account);
        } catch (Exception e) {
            new ResourceErrorException("Exception", "Error", e);
            return null;
        }
    }

    @Override
    public Account updateAccount(Account Account, long UserId) {
        try {
            Account existingAccount = accountRepository.findById(UserId).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "UserId", UserId));

            existingAccount.setAccountNumber(Account.getAccountNumber());
            existingAccount.setBalance(Account.getBalance());
            accountRepository.save(existingAccount);
            return existingAccount;
        } catch (Exception e) {
            new ResourceErrorException("Exception", "Error", e);
            return null;
        }
    }

    @Override
    public void deleteAccount(long UserId) {
        try {
            accountRepository.findById(UserId).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "UserId", UserId));
            accountRepository.deleteById(UserId);
        } catch (Exception e) {
            new ResourceErrorException("Exception", "Error", e);
        }
    }
}
