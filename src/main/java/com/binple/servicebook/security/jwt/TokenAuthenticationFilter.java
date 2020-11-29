package com.binple.servicebook.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;

import static com.binple.servicebook.security.jwt.Constants.HEADER_NAME;
import static com.binple.servicebook.security.jwt.Constants.SECREY_KEY;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

  private final UserDetailsService userDetailsService;

  public TokenAuthenticationFilter(UserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String token = request.getHeader(HEADER_NAME);

    if (token != null && token.startsWith("Bearer ")) {
      token = token.substring(7);

      String username = Jwts.parser().setSigningKey(SECREY_KEY).parseClaimsJws(token).getBody().getSubject();

      if (username != null) {
        UserDetails account = userDetailsService.loadUserByUsername(username);

        TokenBasedAuthentication authentication = new TokenBasedAuthentication(token, account);
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }

    filterChain.doFilter(request, response);
  }
}
