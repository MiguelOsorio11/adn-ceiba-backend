package com.ceiba.trabajodegrado.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;
import com.ceiba.trabajodegrado.puerto.repositorio.RepositorioTrabajoDeGrado;

import java.math.BigDecimal;

public class ServicioCrearTrabajoDeGrado {

    public static final String NOMBRE_DE_TRABAJO_DE_GRADO_EXISTENTE = "El nombre del trabajo de grado ya se encuentra almacenado";
    public static final String VALOR_MINIMO = "El valor minimo para realizar un trabajo de grado es de $150.000";
    public static final BigDecimal minimoValorPorTrabajoDeGrado = new BigDecimal(150000);

    private final RepositorioTrabajoDeGrado repositorioTrabajoDeGrado;

    public ServicioCrearTrabajoDeGrado(RepositorioTrabajoDeGrado repositorioTrabajoDeGrado) {
        this.repositorioTrabajoDeGrado = repositorioTrabajoDeGrado;
    }

    public Long ejecutar(TrabajoDeGrado trabajoDeGrado){
        validarExistenciaTrabajoDeGrado(trabajoDeGrado);
        validarValorMinimo(trabajoDeGrado);
        return this.repositorioTrabajoDeGrado.ejecutar(trabajoDeGrado);
    }

    private void validarExistenciaTrabajoDeGrado(TrabajoDeGrado trabajoDeGrado){

        boolean existeTrabajoDeGrado = this.repositorioTrabajoDeGrado.existe(trabajoDeGrado.getNombre());
        if(existeTrabajoDeGrado){
            throw new ExcepcionDuplicidad(NOMBRE_DE_TRABAJO_DE_GRADO_EXISTENTE);
        }
    }

    private void validarValorMinimo(TrabajoDeGrado trabajoDeGrado){

        if (trabajoDeGrado.getValor().compareTo(minimoValorPorTrabajoDeGrado) == -1)
            throw new ExcepcionValorInvalido(VALOR_MINIMO);
    }
}
