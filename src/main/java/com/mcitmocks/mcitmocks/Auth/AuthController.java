package com.mcitmocks.mcitmocks.Auth;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.mcitmocks.mcitmocks.User.User;
import com.mcitmocks.mcitmocks.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthController {

  @Autowired UserRepository userRepository;

  @PostMapping("/api/auth")
  public AuthResponse authenticateUser(@RequestBody AuthRequest req) {
    try {
      JWTVerifier verifier = new JWTVerifier();
      GoogleIdToken idToken = verifier.verify(req.getAccessToken());
      if (idToken != null) {
        GoogleIdToken.Payload googlePayload = idToken.getPayload();
        String userId = googlePayload.getSubject();
        String email = googlePayload.getEmail();
        Optional<User> _user = userRepository.findById(userId);
        User user;
        if (_user.isPresent()) user = _user.get();
        else {
          user = new User(userId, email);
          userRepository.save(user);
        }
        String token = JWTUtil.generateToken(user);
        return new AuthResponse(token);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new AuthResponse("");
  }
}
