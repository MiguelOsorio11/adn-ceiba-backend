package com.ceiba.trabajodegrado.puerto.repositorio;

import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;

public interface RepositorioTrabajoDeGrado {

    Long ejecutar(TrabajoDeGrado trabajoDeGrado);

    void actualizar(TrabajoDeGrado trabajoDeGrado);

    void eliminar(Long idTrabajoDeGrado);

    boolean existe(String nombre);

    boolean existeExcluyendoId(Long id, String nombre);

    TrabajoDeGrado obtener(Long idTrabajoDeGrado);
}
