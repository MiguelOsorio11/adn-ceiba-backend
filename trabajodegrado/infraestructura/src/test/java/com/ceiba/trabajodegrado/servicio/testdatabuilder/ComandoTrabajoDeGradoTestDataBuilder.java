package com.ceiba.trabajodegrado.servicio.testdatabuilder;

import com.ceiba.trabajodegrado.comando.ComandoTrabajoDeGrado;
import com.ceiba.utils.enums.EstadoTrabajoDeGradoEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ComandoTrabajoDeGradoTestDataBuilder {

    private Long id;
    private Long idUsuario;
    private String nombre;
    private String descripcion;
    private String estado;
    private BigDecimal valor;
    private LocalDateTime fechaConfirmacion;

    public ComandoTrabajoDeGradoTestDataBuilder(){
        idUsuario = 1L;
        nombre = "Applicacion movil";
        descripcion = "trabajo de grado";
        estado = EstadoTrabajoDeGradoEnum.EN_ESPERA.name();
        valor = new BigDecimal(200000);
    }

    public ComandoTrabajoDeGradoTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComandoTrabajoDeGradoTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }

    public ComandoTrabajoDeGradoTestDataBuilder conDescripcion(String descripcion){
        this.descripcion = descripcion;
        return this;
    }

    public ComandoTrabajoDeGradoTestDataBuilder conEstado(String estado){
        this.estado = estado;
        return this;
    }

    public ComandoTrabajoDeGradoTestDataBuilder conFechaConfirmacion(LocalDateTime fechaConfirmacion){
        this.fechaConfirmacion = fechaConfirmacion;
        return this;
    }

    public ComandoTrabajoDeGrado build(){
        return new ComandoTrabajoDeGrado(id,idUsuario,nombre,descripcion,estado,valor,fechaConfirmacion);
    }

}
