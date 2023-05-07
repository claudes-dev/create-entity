package com.descomplica.createentity.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="horario")
    private LocalDateTime horario;

    @Column(name="duracao")
    private Long duracao;

    @Column(name="dataInicio")
    private LocalDate dataInicio;

    @Column(name="dataFim")
    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "instrutor_id", referencedColumnName = "id")
    private Instrutor instrutor;

}
