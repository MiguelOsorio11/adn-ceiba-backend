package com.ceiba.trabajodegrado.modelo.entidad;


import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class TrabajoDeGrado {

    private static final String INGRESO_DE_NOMBRE = "Se debe ingresar el nombre del trabajo de grado";
    private static final String INGRESO_DE_ESTADO = "Se debe ingresar el estado del trabajo de grado";
    private static final String INGRESO_DE_VALOR = "Se debe ingresar el valor del trabajo de grado";

    private Long idUsuario;
    private String nombre;
    private String descripcion;
    private String estado;
    private BigDecimal valor;
    private LocalDateTime fechaConfirmacion;

    public TrabajoDeGrado(Long idUsuario, String nombre, String descripcion, String estado, BigDecimal valor) {
        validarObligatorio(nombre,INGRESO_DE_NOMBRE);
        validarObligatorio(estado, INGRESO_DE_ESTADO);
        validarObligatorio(estado, INGRESO_DE_ESTADO);
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "TrabajoDeGrado{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", valor=" + valor +
                '}';
    }
}
