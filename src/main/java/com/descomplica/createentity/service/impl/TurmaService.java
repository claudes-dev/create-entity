package com.descomplica.createentity.service.impl;

import com.descomplica.createentity.domain.dto.InstrutorResponse;
import com.descomplica.createentity.domain.dto.TurmaResponse;
import com.descomplica.createentity.repository.TurmaRepository;
import com.descomplica.createentity.service.ITurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService implements ITurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public List<TurmaResponse> getALl() {

        var turmaList = turmaRepository.findAll();


        List<TurmaResponse> response = new ArrayList<>();

        turmaList.forEach(turma -> {
            var turmaResponse = new TurmaResponse();
            var instrutor = new InstrutorResponse();

            turmaResponse.setId(turma.getId());
            turmaResponse.setHorario(turma.getHorario());
            turmaResponse.setDuracao(turma.getDuracao());
            turmaResponse.setDataInicio(turma.getDataInicio());
            turmaResponse.setDataFim(turma.getDataFim());

            instrutor.setId(turma.getInstrutor().getId());
            instrutor.setNascimento(turma.getInstrutor().getNascimento());
            instrutor.setNome(turma.getInstrutor().getNome());
            turmaResponse.setInstrutor(instrutor);
            response.add(turmaResponse);
        });

        return response;
    }
}
