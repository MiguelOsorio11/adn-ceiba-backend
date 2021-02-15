package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.dominio.excepcion.ExcepcionCitaInvalida;
import org.junit.jupiter.api.parallel.Resources;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.EnumSet;
import java.util.Set;

public class ServicioCrearCita {

    public final static String ERROR_CITA_FIN_DE_SEMANA ="La cita solo se puede agendar de lunes a viernes";
    public final static String EXISTECIA_HORA_CITA = "Ya se encuentra seleccionada la hora de la cita";


    private RepositorioCita repositorioCine;

    public ServicioCrearCita(RepositorioCita repositorioCine) {
        this.repositorioCine = repositorioCine;
    }

    public Long ejecutar(Cita cita){

        validarDiaEntreSemana(cita.getFechaCita());
        validarExistenciaCita(cita.getFechaCita());
        return this.repositorioCine.ejecutar(cita);
    }

    private void validarDiaEntreSemana(LocalDateTime fechaCita){

        LocalDate date = fechaCita.toLocalDate();
        DayOfWeek dayOfWeek = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
        Set<DayOfWeek> weekend = EnumSet.of( DayOfWeek.SATURDAY , DayOfWeek.SUNDAY );

        if(weekend.contains(dayOfWeek))
            throw new ExcepcionCitaInvalida(ERROR_CITA_FIN_DE_SEMANA);

    }

    private void validarExistenciaCita(LocalDateTime fechaCita){

        boolean existeCita = this.repositorioCine.existeHoraCita(fechaCita);
        if(existeCita)
            throw new ExcepcionCitaInvalida(EXISTECIA_HORA_CITA);
    }

}
