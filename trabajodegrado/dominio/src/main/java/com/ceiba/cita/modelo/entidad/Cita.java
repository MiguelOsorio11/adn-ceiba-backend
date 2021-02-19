package com.ceiba.cita.modelo.entidad;


import com.ceiba.dominio.excepcion.ExcepcionCitaInvalida;
import com.ceiba.utils.enums.MensajeGeneralEnum;
import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class Cita {

        private Long id;
    private Long idTrabajoDeGrado;
    private LocalDateTime fechaCita;

    public Cita(Long id, Long idTrabajoDeGrado, LocalDateTime fechaCita) {
        validarObligatorio(idTrabajoDeGrado,MensajeGeneralEnum.INGRESO_ID_TRABAJO_DE_GRADO.getMensaje());
        validarObligatorio(fechaCita, MensajeGeneralEnum.INGRESO_FECHA_CITA.getMensaje());
        validarFechaCitaMenorDelDiaActual(fechaCita);
        this.id = id;
        this.idTrabajoDeGrado = idTrabajoDeGrado;
        this.fechaCita = fechaCita;
    }

    private void validarFechaCitaMenorDelDiaActual(LocalDateTime fechaCita){

        LocalDate fechaActual = LocalDate.now();
        if(fechaCita.toLocalDate().isBefore(fechaActual))
            throw  new ExcepcionCitaInvalida(MensajeGeneralEnum.FECHA_CITA_MENOR_ACTUAL.getMensaje());
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
