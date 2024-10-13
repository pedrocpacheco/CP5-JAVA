package br.com.fiap.cp2.diplomaprojeto.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.cp2.diplomaprojeto.dto.DiplomaDTO;
import br.com.fiap.cp2.diplomaprojeto.entities.Diploma;
import br.com.fiap.cp2.diplomaprojeto.entities.Sexo;
import br.com.fiap.cp2.diplomaprojeto.repositories.DiplomaRepository;

@Service
public class DiplomaService {

  @Autowired
  private DiplomaRepository diplomaRepository;

  public DiplomaDTO getDiplomaById(UUID id) {
    Diploma diploma = diplomaRepository.findById(id).orElseThrow(() -> new RuntimeException("Diploma não encontrado"));

    DiplomaDTO dto = new DiplomaDTO();
    dto.setTituloReitor(diploma.getSexoReitor() == Sexo.M ? "Prof. Dr. " + diploma.getNomeReitor()
        : "Profa. Dra. " + diploma.getNomeReitor());
    dto.setCargoReitor(diploma.getSexoReitor() == Sexo.M ? "reitor" : "reitora");
    dto.setNomeDiplomado(diploma.getDiplomado().getNome());
    dto.setNacionalidade(diploma.getDiplomado().getNacionalidade());
    dto.setNaturalidade(diploma.getDiplomado().getNaturalidade());
    dto.setRg(diploma.getDiplomado().getRg());
    dto.setTipo(diploma.getCurso().getTipo().toString());
    dto.setNomeCurso(diploma.getCurso().getNome());
    dto.setDataConclusao(diploma.getDataConclusao());

    return dto;
  }
}