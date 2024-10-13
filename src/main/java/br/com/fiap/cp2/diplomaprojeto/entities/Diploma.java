package br.com.fiap.cp2.diplomaprojeto.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Diploma {
  @Id
  private UUID id = UUID.randomUUID();

  @ManyToOne
  private Diplomado diplomado;

  @ManyToOne
  private Curso curso;

  private LocalDate dataConclusao;

  @Enumerated(EnumType.STRING)
  private Sexo sexoReitor;

  @NotBlank
  private String nomeReitor;

  // Getters e Setters
}
