package com.mcitmocks.mcitmocks.Auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JWTAuthentication extends AbstractAuthenticationToken {

  private final String email;

  public JWTAuthentication(String token) {
    super(null);
    this.email = JWTUtil.getEmailFromToken(token);
    if (this.email != null) this.setAuthenticated(true);
  }

  @Override
  public Object getCredentials() {
    return this.email;
  }

  @Override
  public Object getPrincipal() {
    return null;
  }

  @Override
  public Collection<GrantedAuthority> getAuthorities() {
    return super.getAuthorities();
  }

  @Override
  public void setAuthenticated(boolean authenticated) {
    super.setAuthenticated(authenticated);
  }
}
