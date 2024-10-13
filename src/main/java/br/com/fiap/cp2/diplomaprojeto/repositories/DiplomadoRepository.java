package br.com.fiap.cp2.diplomaprojeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cp2.diplomaprojeto.entities.Diplomado;

public interface DiplomadoRepository extends JpaRepository<Diplomado, Long> {
}
