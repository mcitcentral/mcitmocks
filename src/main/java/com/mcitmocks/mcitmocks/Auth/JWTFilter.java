package com.mcitmocks.mcitmocks.Auth;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(
      HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
      throws ServletException, IOException {
    JWTAuthentication authentication = null;
    final String requestTokenHeader = req.getHeader("Authorization");
    if (requestTokenHeader != null) {
      String jwtString = requestTokenHeader.substring(7);
      if (JWTUtil.verifyToken(jwtString)) authentication = new JWTAuthentication(jwtString);
    }
    SecurityContextHolder.getContext().setAuthentication(authentication);
    filterChain.doFilter(req, res);
  }
}
