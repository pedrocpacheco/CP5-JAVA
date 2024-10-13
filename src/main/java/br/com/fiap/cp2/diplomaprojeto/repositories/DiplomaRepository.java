package br.com.fiap.cp2.diplomaprojeto.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cp2.diplomaprojeto.entities.Diploma;

public interface DiplomaRepository extends JpaRepository<Diploma, UUID> {
}
