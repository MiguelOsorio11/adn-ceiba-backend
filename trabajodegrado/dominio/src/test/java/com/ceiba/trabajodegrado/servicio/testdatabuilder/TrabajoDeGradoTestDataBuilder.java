package com.ceiba.trabajodegrado.servicio.testdatabuilder;

import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;
import com.ceiba.utils.enums.EstadoTrabajoDeGradoEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TrabajoDeGradoTestDataBuilder {

    private static final Long ID = 1L;
    private static final Long ID_USUARIO = 1L;
    private static final String NOMBRE = "Proyecto mimercado.com";
    private static final String DESCRIPCION = "realizar documento arquitectura app";
    private static final String ESTADO = EstadoTrabajoDeGradoEnum.EN_ESPERA.getMensaje();
    private static final BigDecimal VALOR = new BigDecimal(200000);
    private static final LocalDateTime FECHA_CONFIRMACION = LocalDateTime.of(2021,02,12,12,30);

    private static final BigDecimal VALOR_MENOR = new BigDecimal(100000);



    private Long id;
    private Long idUsuario;
    private String nombre;
    private String descripcion;
    private String estado;
    private BigDecimal valor;
    private LocalDateTime fechaConfirmacion;

    public TrabajoDeGradoTestDataBuilder(){
        id = ID;
        idUsuario = ID_USUARIO;
        nombre = NOMBRE;
        descripcion = DESCRIPCION;
        estado = ESTADO;
        valor = VALOR;
    }

    public TrabajoDeGrado build(){
        return new TrabajoDeGrado(id,idUsuario,nombre,descripcion,estado,valor,fechaConfirmacion);
    }

    public TrabajoDeGradoTestDataBuilder conFechaConfirmacionCorrecta(){
        this.fechaConfirmacion = FECHA_CONFIRMACION;
        return this;
    }

    public TrabajoDeGradoTestDataBuilder conValorMenor(){
        this.valor = VALOR_MENOR;
        return this;
    }

}
