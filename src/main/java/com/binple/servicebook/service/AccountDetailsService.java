package com.binple.servicebook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.binple.servicebook.exception.AccountNotFoundException;
import com.binple.servicebook.model.Account;
import com.binple.servicebook.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailsService implements UserDetailsService {

  private AccountRepository repository;

  @Autowired
  public AccountDetailsService(AccountRepository repository) {
    this.repository = repository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) {

    Optional<Account> entity = repository.findByEmail(username);
    if (!entity.isPresent()) {
      throw new AccountNotFoundException("Account with the given username not found");
    }

    Account account = entity.get();

    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_" + account.getClass().getSimpleName().toUpperCase()));

    return new User(account.getEmail(), account.getPassword(), authorities);
  }
}
