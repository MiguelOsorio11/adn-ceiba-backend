package com.ceiba.trabajodegrado.modelo.entidad;


import com.ceiba.utils.enums.EstadoTrabajoDeGradoEnum;
import com.ceiba.utils.enums.MensajeGeneralEnum;
import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

import java.math.BigDecimal;

@Getter
public class TrabajoDeGrado {

    private Long idUsuario;
    private String nombre;
    private String descripcion;
    private String estado;
    private BigDecimal valor;

    public TrabajoDeGrado(Long idUsuario, String nombre, String descripcion, String estado, BigDecimal valor) {
        validarObligatorio(idUsuario,MensajeGeneralEnum.INGRESO_ID_USUARIO.getMensaje());
        validarObligatorio(nombre, MensajeGeneralEnum.INGRESO_DE_NOMBRE.getMensaje());
        validarObligatorio(estado, MensajeGeneralEnum.INGRESO_DE_ESTADO.getMensaje());
        validarObligatorio(valor, MensajeGeneralEnum.INGRESO_DE_VALOR.getMensaje());
        validarPositivo(valor.doubleValue(), MensajeGeneralEnum.INGRESO_VALOR_POSITIVO.getMensaje());
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
