package com.example.hometest.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hometest.Account.*;

@RestController
@RequestMapping("/Account")
public class AccountController {
    @Autowired
    private ModelMapper modelMapper;

    private AccountServiceImpl accountServiceImpl;

    public AccountController(AccountServiceImpl accountServiceImpl) {
        super();
        this.accountServiceImpl = accountServiceImpl;
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountServiceImpl.getAllAccounts()
                .stream()
                .map(post -> modelMapper.map(post, Account.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountByUserId(@PathVariable(name = "id") Long id) {
        Account account = accountServiceImpl.getAccountByUserId(id);
        // convert entity to DTO
        AccountDto accountResponse = modelMapper.map(account, AccountDto.class);
        return ResponseEntity.ok().body(accountResponse);
    }

    @PostMapping
    public ResponseEntity<AccountDto> saveAccount(@RequestBody AccountDto accountDto) {
        // convert DTO to entity
        Account accountRequest = modelMapper.map(accountDto, Account.class);
        Account account = accountServiceImpl.saveAccount(accountRequest);
        // convert entity to DTO
        AccountDto accountResponse = modelMapper.map(account, AccountDto.class);
        return new ResponseEntity<AccountDto>(accountResponse, HttpStatus.CREATED);
    }

    // change the request for DTO
    // change the response for DTO
    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable long id, @RequestBody AccountDto accountDto) {
        // convert DTO to Entity
        Account accountRequest = modelMapper.map(accountDto, Account.class);
        Account account = accountServiceImpl.updateAccount(accountRequest, id);
        // entity to DTO
        AccountDto accountResponse = modelMapper.map(account, AccountDto.class);
        return ResponseEntity.ok().body(accountResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable(name = "id") Long id) {
        accountServiceImpl.deleteAccount(id);
        return new ResponseEntity<String>("User deleted successfully!.", HttpStatus.OK);
    }
}
