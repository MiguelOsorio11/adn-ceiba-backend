package com.ceiba.dominio.excepcion;

public class ExcepcionCancelacionTrabajoDeGrado extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionCancelacionTrabajoDeGrado(String message) { super(message); }
}
