package com.ceiba.cita.servicio.testdatabuilder;

import com.ceiba.cita.ComandoCita;

import java.time.LocalDateTime;

public class ComandoCitaTestDataBuilder {

    private Long id;
    private Long idTrabajoDeGrado;
    private LocalDateTime fechaCita;

    public ComandoCitaTestDataBuilder (){
        idTrabajoDeGrado = 1L;
        fechaCita = LocalDateTime.of(2021,02,15,12,30);
    }

    public ComandoCitaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComandoCitaTestDataBuilder conIdTrabajoDeGrado(Long idTrabajoDeGrado){
        this.idTrabajoDeGrado = idTrabajoDeGrado;
        return this;
    }

    public ComandoCitaTestDataBuilder conFechaCita(LocalDateTime fechaCita){
        this.fechaCita = fechaCita;
        return this;
    }

    public ComandoCita build(){
        return new ComandoCita(id,idTrabajoDeGrado,fechaCita);
    }
}
