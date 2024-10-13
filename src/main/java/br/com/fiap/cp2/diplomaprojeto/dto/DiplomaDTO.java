package br.com.fiap.cp2.diplomaprojeto.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiplomaDTO {
  private String tituloReitor;
  private String cargoReitor;
  private String nomeDiplomado;
  private String nacionalidade;
  private String naturalidade;
  private String rg;
  private String tipo;
  private String nomeCurso;
  private LocalDate dataConclusao;
}