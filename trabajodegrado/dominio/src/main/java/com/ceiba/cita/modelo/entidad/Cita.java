package com.ceiba.cita.modelo.entidad;


import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

@Getter
public class Cita {

    private static final String INGRESO_FECHA_CITA= "Se debe ingresar la fecha de la cita";

    private Long id;
    private Long idTrabajoDeGrado;
    private LocalDateTime fechaCita;

    public Cita(Long id, Long idTrabajoDeGrado, LocalDateTime fechaCita) {
        validarObligatorio(fechaCita,INGRESO_FECHA_CITA);
        this.id = id;
        this.idTrabajoDeGrado = idTrabajoDeGrado;
        this.fechaCita = fechaCita;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", idTrabajoDeGrado=" + idTrabajoDeGrado +
                ", fechaCita=" + fechaCita +
                '}';
    }
}
