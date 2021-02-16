package com.ceiba.trabajodegrado.puerto.repositorio;

import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;

import java.time.LocalDateTime;

public interface RepositorioTrabajoDeGrado {

    Long ejecutar(TrabajoDeGrado trabajoDeGrado);

    void actualizar(Long id, TrabajoDeGrado trabajoDeGrado, LocalDateTime fechaConfirmacion);

    void eliminar(Long idTrabajoDeGrado);

    boolean existe(String nombre);

    boolean existeExcluyendoId(Long id, String nombre);

    TrabajoDeGrado obtener(Long idTrabajoDeGrado);
}
