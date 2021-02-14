package com.ceiba.puntotrabajodegrado.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PuntoTrabajoDeGrado {

    private static final String ERROR_INGRESAR_NOMBRE = "Se debe ingresar el nombre del punto a realizar en el trabajo de grado";
    private static final String ERROR_INGRESAR_VALOR = "Se debe ingresar el valor del punto a realizar en el trabajo de grado";

    private Long id;
    private String nombre;
    private BigDecimal valor;

    public PuntoTrabajoDeGrado(Long id, String nombre, BigDecimal valor) {
        validarObligatorio(nombre, ERROR_INGRESAR_NOMBRE);
        validarObligatorio(nombre, ERROR_INGRESAR_NOMBRE);
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "PuntosTrabajoDeGrado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }
}
