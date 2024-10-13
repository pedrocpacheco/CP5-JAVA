package br.com.fiap.cp2.diplomaprojeto.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
  private String username;
  private String password;
}
