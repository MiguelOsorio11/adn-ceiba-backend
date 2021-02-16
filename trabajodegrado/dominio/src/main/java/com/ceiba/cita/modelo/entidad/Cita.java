package com.ceiba.cita.modelo.entidad;


import com.ceiba.utils.enums.MensajeGeneralEnum;
import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

@Getter
public class Cita {

    private Long id;
    private Long idTrabajoDeGrado;
    private LocalDateTime fechaCita;

    public Cita(Long id, Long idTrabajoDeGrado, LocalDateTime fechaCita) {
        validarObligatorio(idTrabajoDeGrado,MensajeGeneralEnum.INGRESO_ID_TRABAJO_DE_GRADO.getMensaje());
        validarObligatorio(fechaCita, MensajeGeneralEnum.INGRESO_FECHA_CITA.getMensaje());
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
