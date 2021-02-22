package com.ceiba.cita.puerto.repositorio;

import com.ceiba.cita.modelo.entidad.Cita;

import java.time.LocalDateTime;

public interface RepositorioCita {

    Long ejecutar(Cita cita);

    void actualizar(Cita cita);

    boolean existeHoraCita(LocalDateTime horaCita);

    boolean verificarExistenciaTrabajoDeGrado(Long id);
}
