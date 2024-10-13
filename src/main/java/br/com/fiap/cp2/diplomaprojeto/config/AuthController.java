package br.com.fiap.cp2.diplomaprojeto.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cp2.diplomaprojeto.controller.AuthRequest;
import br.com.fiap.cp2.diplomaprojeto.dto.UserRegistrationRequest;
import br.com.fiap.cp2.diplomaprojeto.entities.Role;
import br.com.fiap.cp2.diplomaprojeto.entities.User;
import br.com.fiap.cp2.diplomaprojeto.repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private UserRepository userRepository;

  private String secretKey = "PASSKEY";

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

    UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());

    String token = Jwts.builder()
        .setSubject(userDetails.getUsername())
        .signWith(SignatureAlgorithm.HS256, secretKey)
        .compact();

    Map<String, String> response = new HashMap<>();
    response.put("token", token);

    return ResponseEntity.ok(response);
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody UserRegistrationRequest request) {
    User user = new User();
    user.setUsername(request.getUsername());
    user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
    user.setRole(Role.valueOf(request.getRole().toUpperCase()));
    userRepository.save(user);
    return ResponseEntity.ok("Usuário registrado com sucesso!");
  }
}
