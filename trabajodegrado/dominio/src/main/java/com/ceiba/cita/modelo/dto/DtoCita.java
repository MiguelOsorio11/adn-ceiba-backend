package com.ceiba.cita.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCita {
    private Long id;
    private Long idTrabajoDeGrado;
    private LocalDateTime fechaCita;
}
