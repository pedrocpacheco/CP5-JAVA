package br.com.fiap.cp2.diplomaprojeto.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cp2.diplomaprojeto.dto.DiplomaDTO;
import br.com.fiap.cp2.diplomaprojeto.services.DiplomaService;

@RestController
@RequestMapping("/diplomas")
public class DiplomaController {

  @Autowired
  private DiplomaService diplomaService;

  @GetMapping("/{id}")
  @PreAuthorize("hasRole('USER')")
  public ResponseEntity<String> getDiploma(@PathVariable UUID id) {
    DiplomaDTO diplomaDTO = diplomaService.getDiplomaById(id);
    String textoDiploma = generateDiplomaText(diplomaDTO);
    return ResponseEntity.ok(textoDiploma);
  }

  private String generateDiplomaText(DiplomaDTO dto) {
    return String.format(
        "%s, %s da Universidade Fake, no uso de suas atribuições, confere a %s, de nacionalidade %s, " +
            "natural de %s, portador do rg %s, o presente diploma de %s, do curso de %s, " +
            "por ter concluído seus estudos nesta instituição de ensino no dia %s.",
        dto.getTituloReitor(), dto.getCargoReitor(), dto.getNomeDiplomado(),
        dto.getNacionalidade(), dto.getNaturalidade(), dto.getRg(),
        dto.getTipo(), dto.getNomeCurso(), dto.getDataConclusao());
  }
}