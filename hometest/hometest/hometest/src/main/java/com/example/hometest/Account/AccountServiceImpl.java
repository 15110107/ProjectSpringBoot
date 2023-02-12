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
    public List<Account> getAllAccounts(Iterable<Long> UserId) {
        try {
            return accountRepository.findAllById(UserId);
        } catch (Exception e) {
            new ResourceErrorException("Exception", "Error", e);
            return null;
        }
    }

    @Override
    public Account getAccountByNumber(Iterable<Long> UserId, int AccountNumber) {
        try {
            List<Account> ListAccount = accountRepository.findAllById(UserId);
            for (Account account : ListAccount) {
                if (account.getAccountNumber() = AccountNumber) {

                }
            }
            // return
            // ListAccount.stream().filter(Account.class::isInstance).map(Account::AccountNumber)
            // .orElseThrow(
            // () -> new ResourceNotFoundException("Account", "UserId", UserId));
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
