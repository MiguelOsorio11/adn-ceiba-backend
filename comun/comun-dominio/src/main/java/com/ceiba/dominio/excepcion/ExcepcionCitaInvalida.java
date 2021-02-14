package com.ceiba.dominio.excepcion;

public class ExcepcionCitaInvalida extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionCitaInvalida (String message) {
        super(message);
    }
}
