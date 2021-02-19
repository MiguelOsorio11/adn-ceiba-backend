package com.ceiba.cita.servicio.testdatabuilder;

import com.ceiba.cita.modelo.entidad.Cita;

import java.time.LocalDateTime;

public class CitaTestDataBuilder {

    private static final Long ID =1L;
    private static final Long ID_TRABAJO_DE_GRADO = 1L;
    private static final LocalDateTime FECHA_CITA = LocalDateTime.of(2021,03,18,12,30);

    private static final LocalDateTime FECHA_CITA_DIA_INCORRECTO = LocalDateTime.of(2021,03,13,12,30);
    private static final LocalDateTime FECHA_CITA_HORA_INCORRECTA = LocalDateTime.of(2021,03,15,2,30);
    private static final LocalDateTime FECHA_CITA_INFERIOR_DIA_ACTUAL = LocalDateTime.of(2021,02,15,10,20);


    private Long id;
    private Long idTrabajoDeGrado;
    private LocalDateTime fechaCita;

    public CitaTestDataBuilder(){
        id = ID;
        idTrabajoDeGrado =ID_TRABAJO_DE_GRADO;
        fechaCita = FECHA_CITA;
    }

    public Cita build(){
        return new Cita(id,idTrabajoDeGrado,fechaCita);
    }

    public CitaTestDataBuilder conFechaCitaDiaIncorrecto(){
        this.fechaCita = FECHA_CITA_DIA_INCORRECTO;
        return this;
    }

    public CitaTestDataBuilder conFechaCitaHoraIncorrecta(){
        this.fechaCita = FECHA_CITA_HORA_INCORRECTA;
        return this;
    }

    public Cita conIdTrabajoDeGradoNull(){
        return new Cita(id,null,fechaCita);
    }

    public Cita conFechaNull(){
        return new Cita(id,idTrabajoDeGrado,null);
    }

    public Cita conFechaConfirmacionMenorActual(){
        return new Cita(id,idTrabajoDeGrado,FECHA_CITA_INFERIOR_DIA_ACTUAL);
    }

}
