package com.ceiba.trabajodegrado.servicio;

import com.ceiba.trabajodegrado.puerto.repositorio.RepositorioTrabajoDeGrado;

public class ServicioEliminarTrabajoDeGrado {

    private final RepositorioTrabajoDeGrado repositorioTrabajoDeGrado;

    public ServicioEliminarTrabajoDeGrado(RepositorioTrabajoDeGrado repositorioTrabajoDeGrado) {
        this.repositorioTrabajoDeGrado = repositorioTrabajoDeGrado;
    }

    public void ejecutar(Long idTrabajoDeGrado){ this.repositorioTrabajoDeGrado.eliminar(idTrabajoDeGrado); }
}
