package com.ceiba.trabajodegrado.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionCancelacionTrabajoDeGrado;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.trabajodegrado.modelo.entidad.TrabajoDeGrado;
import com.ceiba.trabajodegrado.puerto.repositorio.RepositorioTrabajoDeGrado;
import com.ceiba.trabajodegrado.servicio.testdatabuilder.TrabajoDeGradoTestDataBuilder;
import com.ceiba.utils.enums.EstadoTrabajoDeGradoEnum;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class ServicioCancelarTrabajoDeGradoTest {

    @Test
    public void validarFechaConfirmacionMenor24Horas(){
        // arrange
        Long id = 1L;
        LocalDateTime fechaConfirmacion = LocalDateTime.of(2021,02,18,10,20);
        TrabajoDeGrado trabajoDeGrado = new TrabajoDeGradoTestDataBuilder().build();
        RepositorioTrabajoDeGrado repositorioTrabajoDeGrado = Mockito.mock(RepositorioTrabajoDeGrado.class);

        ServicioCancelarTrabajoDeGrado servicioCancelarTrabajoDeGrado = new ServicioCancelarTrabajoDeGrado(repositorioTrabajoDeGrado);
        // act- arrange
        BasePrueba.assertThrows(() -> servicioCancelarTrabajoDeGrado.ejecutar(id,EstadoTrabajoDeGradoEnum.CANCELADO,fechaConfirmacion), ExcepcionCancelacionTrabajoDeGrado.class, ServicioCancelarTrabajoDeGrado.CANCELACION_INVALIDA);
    }

}
