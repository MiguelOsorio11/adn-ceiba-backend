package com.ceiba.trabajodegrado.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;
import com.ceiba.trabajodegrado.puerto.repositorio.RepositorioTrabajoDeGrado;

import java.util.Optional;

public class ServicioActualizarTrabajoDeGrado {

    public static final String NOMBRE_DE_TRABAJO_DE_GRADO_EXISTENTE = "El nombre del trabajo de grado ya se encuentra almacenado";

    private final RepositorioTrabajoDeGrado repositorioTrabajoDeGrado;

    public ServicioActualizarTrabajoDeGrado(RepositorioTrabajoDeGrado repositorioTrabajoDeGrado) {
        this.repositorioTrabajoDeGrado = repositorioTrabajoDeGrado;
    }

    public void ejecutar(TrabajoDeGrado trabajoDeGrado){

        validarActualizacionNombre(trabajoDeGrado);
        this.repositorioTrabajoDeGrado.actualizar(trabajoDeGrado);
    }

    public void validarActualizacionNombre(TrabajoDeGrado trabajoDeGrado){
        System.out.println("ENTRO ACTUALIZAR");
        boolean existeTrabajoDeGrado = this.repositorioTrabajoDeGrado.existeExcluyendoId(trabajoDeGrado.getId(), trabajoDeGrado.getNombre());
        System.out.println("existeTrabajoDeGrado "+existeTrabajoDeGrado);
        if(existeTrabajoDeGrado){
            throw new ExcepcionDuplicidad(NOMBRE_DE_TRABAJO_DE_GRADO_EXISTENTE);
        }
    }
}
