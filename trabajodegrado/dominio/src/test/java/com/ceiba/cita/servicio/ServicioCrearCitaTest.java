package com.ceiba.cita.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import static org.junit.Assert.assertEquals;

import com.ceiba.dominio.excepcion.ExcepcionCitaInvalida;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.utils.enums.MensajeGeneralEnum;
import org.junit.Test;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

public class ServicioCrearCitaTest {

    @Test
    public void validarCreacionCita(){
        // arrange
        Cita cita = new CitaTestDataBuilder().build();
        RepositorioCita repositorioCita = mock(RepositorioCita.class);

        when(repositorioCita.existeHoraCita(cita.getFechaCita())).thenReturn(Boolean.FALSE);
        when(repositorioCita.verificarExistenciaTrabajoDeGrado(cita.getIdTrabajoDeGrado())).thenReturn(Boolean.TRUE);
        when(repositorioCita.ejecutar(cita)).thenReturn(cita.getId());

        // act
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        Long idCita = servicioCrearCita.ejecutar(cita);

        // assert
        assertEquals(cita.getId(),idCita);
    }

    @Test
    public void validarFechaCitaDiaFinDeSemana(){
        // arrange
        Cita cita = new CitaTestDataBuilder().conFechaCitaDiaIncorrecto().build();
        RepositorioCita repositorioCita = mock(RepositorioCita.class);

        when(repositorioCita.verificarExistenciaTrabajoDeGrado(cita.getIdTrabajoDeGrado())).thenReturn(Boolean.TRUE);


        // act- arrange
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionCitaInvalida.class, MensajeGeneralEnum.ERROR_CITA_FIN_DE_SEMANA.getMensaje());
    }

    @Test
    public void validarFechaCitaHoraIncorrecta(){
        // arrange
        Cita cita = new CitaTestDataBuilder().conFechaCitaHoraIncorrecta().build();
        RepositorioCita repositorioCita = mock(RepositorioCita.class);

        when(repositorioCita.verificarExistenciaTrabajoDeGrado(cita.getIdTrabajoDeGrado())).thenReturn(Boolean.TRUE);
        when(repositorioCita.existeHoraCita(cita.getFechaCita())).thenReturn(Boolean.TRUE);

        // act- arrange
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionCitaInvalida.class, MensajeGeneralEnum.EXISTECIA_HORA_CITA.getMensaje());
    }

    @Test
    public void validarTrabajoDeGradoIncorrecto(){
        // arrange
        Cita cita = new CitaTestDataBuilder().conFechaCitaHoraIncorrecta().build();
        RepositorioCita repositorioCita = mock(RepositorioCita.class);

        when(repositorioCita.verificarExistenciaTrabajoDeGrado(cita.getIdTrabajoDeGrado())).thenReturn(Boolean.FALSE);

        // act- arrange
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionSinDatos.class, MensajeGeneralEnum.EXISTENCIA_TRABAJO_GRADO.getMensaje());
    }
}
