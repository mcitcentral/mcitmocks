package com.mcitmocks.mcitmocks.Auth;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class JWTVerifier {

  @Value("${google-client-id}")
  private String googleClientId;

  private final GoogleIdTokenVerifier verifier;

  public JWTVerifier() {
    System.out.println(this.getClientId());
    this.verifier =
        new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
            .setAudience(Collections.singletonList(this.googleClientId))
            .build();
  }

  private String getClientId() {
    return this.googleClientId;
  }

  public GoogleIdToken verify(String token) {
    try {
      return this.verifier.verify(token);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
