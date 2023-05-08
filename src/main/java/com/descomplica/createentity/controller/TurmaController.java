package com.descomplica.createentity.controller;

import com.descomplica.createentity.domain.dto.TurmaResponse;
import com.descomplica.createentity.domain.entity.Turma;
import com.descomplica.createentity.service.ITurmaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private ITurmaService iTurmaService;

    @GetMapping
    @Operation(summary="Listar todas as Turmas", description  = "Listagem de Turmas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição Inválida"),
            @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso."),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    public ResponseEntity<List<TurmaResponse>> getAll(){


        var listTurmas = iTurmaService.getALl();

        return ResponseEntity.ok(listTurmas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> getById(@PathVariable Long id) {
        var turma = iTurmaService.getById(id);
        return turma.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Turma> saveTurma(@RequestBody Turma turma) {
        return new ResponseEntity<>(iTurmaService.saveTurma(turma), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> updateTurma(@PathVariable Long id, @RequestBody Turma turma) {
        Turma turmaAtualizada = iTurmaService.updateTurma(id, turma);
        if(turmaAtualizada != null)
            return new ResponseEntity<>(turmaAtualizada, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTurma(@PathVariable Long id) {
        if(iTurmaService.deleteTurma(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }
}
