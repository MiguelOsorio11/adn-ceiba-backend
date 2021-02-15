package com.ceiba.trabajodegrado.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;
import com.ceiba.trabajodegrado.puerto.repositorio.RepositorioTrabajoDeGrado;


public class ServicioActualizarTrabajoDeGrado {

    public static final String NOMBRE_DE_TRABAJO_DE_GRADO_EXISTENTE = "El nombre del trabajo de grado ya se encuentra almacenado";

    private final RepositorioTrabajoDeGrado repositorioTrabajoDeGrado;

    public ServicioActualizarTrabajoDeGrado(RepositorioTrabajoDeGrado repositorioTrabajoDeGrado) {
        this.repositorioTrabajoDeGrado = repositorioTrabajoDeGrado;
    }

    public void ejecutar(Long idTrabajoDeGrado, TrabajoDeGrado trabajoDeGrado){

        validarActualizacionNombre(idTrabajoDeGrado,trabajoDeGrado);
        this.repositorioTrabajoDeGrado.actualizar(trabajoDeGrado);
    }

    public void validarActualizacionNombre(Long idTrabajoDeGrado, TrabajoDeGrado trabajoDeGrado){

        boolean existeTrabajoDeGrado = this.repositorioTrabajoDeGrado.existeExcluyendoId(idTrabajoDeGrado, trabajoDeGrado.getNombre());
        if(existeTrabajoDeGrado){
            throw new ExcepcionDuplicidad(NOMBRE_DE_TRABAJO_DE_GRADO_EXISTENTE);
        }
    }
}
