package com.descomplica.createentity.service;

import com.descomplica.createentity.domain.dto.TurmaResponse;
import com.descomplica.createentity.domain.entity.Turma;

import java.util.List;
import java.util.Optional;

public interface ITurmaService {


    List<TurmaResponse> getALl();

    Optional<Turma> getById(Long id);

    boolean deleteTurma(Long id);

    Turma updateTurma(Long id, Turma turma);

    Turma saveTurma(Turma turma);
}
