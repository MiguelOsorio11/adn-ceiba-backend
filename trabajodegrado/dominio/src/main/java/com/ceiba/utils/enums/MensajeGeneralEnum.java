package com.ceiba.utils.enums;

import lombok.Getter;

@Getter
public enum MensajeGeneralEnum {

    //Mensajes Trabajo de grado
    INGRESO_ID_USUARIO("Se debe ingresar un usuario para asociar con el trabajo de grado"),
    INGRESO_DE_NOMBRE("Se debe ingresar el nombre del trabajo de grado"),
    INGRESO_DE_ESTADO("Se debe ingresar el estado del trabajo de grado"),
    INGRESO_DE_VALOR("Se debe ingresar el valor del trabajo de grado"),
    INGRESO_VALOR_POSITIVO("Se debe ingresar un valor positivo para el trabajo de grado"),

    //Mensajes Cita
    INGRESO_ID_TRABAJO_DE_GRADO("Se debe asociar un trabajo de grado a la cita"),
    INGRESO_FECHA_CITA("Se debe ingresar la fecha de la cita"),
    ERROR_CITA_FIN_DE_SEMANA("La cita solo se puede agendar de lunes a viernes"),
    EXISTECIA_HORA_CITA("Ya se encuentra seleccionada la hora de la cita"),
    FECHA_CITA_MENOR_ACTUAL("La fecha de la cita debe ser mayor o igual del dia actual");

    private final String mensaje;

    MensajeGeneralEnum(String mensaje){ this.mensaje = mensaje; }
}
