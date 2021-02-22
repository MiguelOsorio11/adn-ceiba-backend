package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.dominio.excepcion.ExcepcionCitaInvalida;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.utils.enums.MensajeGeneralEnum;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.EnumSet;
import java.util.Set;

public class ServicioCrearCita {

    private RepositorioCita repositorioCine;

    public ServicioCrearCita(RepositorioCita repositorioCine) {
        this.repositorioCine = repositorioCine;
    }

    public Long ejecutar(Cita cita){

        validarExistenciaTrabajoDeGrado(cita.getIdTrabajoDeGrado());
        validarDiaEntreSemana(cita.getFechaCita());
        validarExistenciaCita(cita.getFechaCita());
        return this.repositorioCine.ejecutar(cita);
    }

    private void validarDiaEntreSemana(LocalDateTime fechaCita){

        LocalDate date = fechaCita.toLocalDate();
        DayOfWeek dayOfWeek = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
        Set<DayOfWeek> weekend = EnumSet.of( DayOfWeek.SATURDAY , DayOfWeek.SUNDAY );

        if(weekend.contains(dayOfWeek))
            throw new ExcepcionCitaInvalida(MensajeGeneralEnum.ERROR_CITA_FIN_DE_SEMANA.getMensaje());

    }

    private void validarExistenciaCita(LocalDateTime fechaCita){

        boolean existeCita = this.repositorioCine.existeHoraCita(fechaCita);
        if(existeCita)
            throw new ExcepcionCitaInvalida(MensajeGeneralEnum.EXISTECIA_HORA_CITA.getMensaje());
    }

    private void validarExistenciaTrabajoDeGrado(Long id){

        boolean existeTrabajoDeGrado = this.repositorioCine.verificarExistenciaTrabajoDeGrado(id);
        if(!existeTrabajoDeGrado)
            throw new ExcepcionSinDatos(MensajeGeneralEnum.EXISTENCIA_TRABAJO_GRADO.getMensaje());
    }


}
