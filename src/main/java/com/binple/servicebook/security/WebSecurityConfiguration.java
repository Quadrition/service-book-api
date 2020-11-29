package com.binple.servicebook.security;

import com.binple.servicebook.service.AccountDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final AccountDetailsService accountDetailsService;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public WebSecurityConfiguration(AccountDetailsService accountDetailsService,
      BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.accountDetailsService = accountDetailsService;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Bean
  @Override
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
        .anyRequest().permitAll().and().cors().and().csrf().disable();
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(accountDetailsService).passwordEncoder(bCryptPasswordEncoder);
  }
}
