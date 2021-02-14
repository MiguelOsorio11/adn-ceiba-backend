package com.ceiba.trabajodegrado.modelo.entidad;


import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class TrabajoDeGrado {

    private static final String INGRESO_DE_NOMBRE = "Se debe ingresar el nombre del proyecto";

    private Long id;
    private Long idUsuario;
    private String nombre;
    private String descripcion;
    private String estado;
    private BigDecimal valor;
    private LocalDateTime fechaConfirmacion;

    public TrabajoDeGrado(Long id, Long idUsuario, String nombre, String descripcion, String estado, BigDecimal valor, LocalDateTime fechaConfirmacion) {
        validarObligatorio(nombre,INGRESO_DE_NOMBRE);
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.valor = valor;
        this.fechaConfirmacion = fechaConfirmacion;
    }

    @Override
    public String toString() {
        return "TrabajoDeGrado{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", valor=" + valor +
                '}';
    }
}
