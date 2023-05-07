package com.descomplica.createentity.domain.dto;

import com.descomplica.createentity.domain.entity.Instrutor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurmaResponse {

    private Long id;
    private LocalDateTime horario;
    private Long duracao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private InstrutorResponse instrutor;

}
