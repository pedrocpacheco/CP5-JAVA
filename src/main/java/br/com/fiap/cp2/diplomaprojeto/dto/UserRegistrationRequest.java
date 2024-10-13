package br.com.fiap.cp2.diplomaprojeto.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequest {
  private String username;
  private String password;
  private String role;
}
