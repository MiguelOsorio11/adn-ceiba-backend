package com.ceiba.utils.enums;

import lombok.Getter;

@Getter
public enum EstadoTrabajoDeGradoEnum {

    EN_ESPERA("En Espera"),
    EN_PROGRESO("En Progreso"),
    CANCELADO("Cancelado"),
    FINALIZADO("Finalizado");

    private final String mensaje;

    EstadoTrabajoDeGradoEnum(String mensaje){
        this.mensaje = mensaje;
    }
}
